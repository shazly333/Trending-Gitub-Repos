package com.example.trendingGithubRepos.Services;

import com.example.trendingGithubRepos.dtos.Language;

import java.util.List;

public interface TrendingReposService {
  List<Language> fetchTrendingRepos();
}
