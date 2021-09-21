package com.example.trendingGithubRepos.Services;

import com.example.trendingGithubRepos.dtos.Language;
import com.example.trendingGithubRepos.dtos.TrendingRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TrendingReposServiceImpl implements TrendingReposService {

  public static final String LANGUAGE = "language";
  public static final String DATE = "date";
  public static final String URL = "https://api.github.com/search/repositories?q=created:<{date}&sort=stars&order=desc&per_page=100";
  public static final String NO_LANGUAGE_SPECIFIED = "No Language Specified";

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Language> fetchTrendingRepos() {
    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
    String nowAsISO = df.format(new Date());
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put(DATE, nowAsISO);
    try {
      TrendingRepos trendingRepos = restTemplate.getForObject(URL, TrendingRepos.class, uriVariables);
      HashMap<String, Language> languages = new HashMap<>();
      for (LinkedHashMap<String, Object> repo : trendingRepos.getItems()) {
        String repoLanguage;
        if (repo.get(LANGUAGE) != null) {
          repoLanguage = repo.get(LANGUAGE).toString();
        } else {
          repoLanguage = NO_LANGUAGE_SPECIFIED;
        }
        Language language = languages.getOrDefault(repoLanguage, new Language(repoLanguage));
        language.setNumberOfReposUseLanguage(language.getNumberOfReposUseLanguage() + 1);
        language.getTrendingRepos().getItems().add(repo);
        languages.put(repoLanguage, language);
      }
      List<Language> trendingLanguages = new ArrayList<>(languages.values());
      Collections.sort(trendingLanguages, (s1, s2) -> s2.getNumberOfReposUseLanguage() - s1.getNumberOfReposUseLanguage());
      return trendingLanguages;
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
