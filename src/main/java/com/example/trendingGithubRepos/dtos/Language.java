package com.example.trendingGithubRepos.dtos;

public class Language {
  String name;
  TrendingRepos trendingRepos = new TrendingRepos();
  int numberOfReposUseLanguage = 0;

  public Language() {
  }

  public Language(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrendingRepos getTrendingRepos() {
    return trendingRepos;
  }

  public void setTrendingRepos(TrendingRepos trendingRepos) {
    this.trendingRepos = trendingRepos;
  }

  public int getNumberOfReposUseLanguage() {
    return numberOfReposUseLanguage;
  }

  public void setNumberOfReposUseLanguage(int numberOfReposUseLanguage) {
    this.numberOfReposUseLanguage = numberOfReposUseLanguage;
  }
}
