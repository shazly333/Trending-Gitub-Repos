package com.example.trendingGithubRepos.RestApi;

import com.example.trendingGithubRepos.Services.TrendingReposService;
import com.example.trendingGithubRepos.dtos.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrendingGithubReposController {

  @Autowired
  TrendingReposService trendingReposService;

  @GetMapping("/trending/github/repos")
  public List<Language> fetchTrendingRepos() {
    return trendingReposService.fetchTrendingRepos();
  }
}