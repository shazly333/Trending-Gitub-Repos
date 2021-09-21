import com.example.trendingGithubRepos.Services.TrendingReposService;
import com.example.trendingGithubRepos.config.TrendingGithubRepos;
import com.example.trendingGithubRepos.dtos.Language;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TrendingGithubRepos.class)
@AutoConfigureMockMvc
public class ServicesTests {

  @Autowired
  private TrendingReposService trendingReposService;

  @Test
  public void validateNumberOfTrendingRepos() {
    List<Language> languages = trendingReposService.fetchTrendingRepos();
    int numberOfRepos = 0;
    for(Language language : languages){
      numberOfRepos += language.getNumberOfReposUseLanguage();
    }
    assertSame(numberOfRepos, 100);
  }

  @Test
  public void sortingTest() {
    List<Language> languages = trendingReposService.fetchTrendingRepos();
    for(int i = 1; i < languages.size(); i++){
      assertThat(languages.get(i).getNumberOfReposUseLanguage(), lessThanOrEqualTo(languages.get(i - 1).getNumberOfReposUseLanguage()));
    }
  }

  @Test
  public void contextLoads() {
  }
}

