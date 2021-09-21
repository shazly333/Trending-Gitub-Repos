package com.example.trendingGithubRepos.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrendingRepos {

  @JsonProperty("items")
  ArrayList<LinkedHashMap<String, Object>> items = new ArrayList<>();

  public ArrayList<LinkedHashMap<String, Object>> getItems() {
    return items;
  }

  public void setItems(ArrayList<LinkedHashMap<String, Object>> items) {
    this.items = items;
  }
}
