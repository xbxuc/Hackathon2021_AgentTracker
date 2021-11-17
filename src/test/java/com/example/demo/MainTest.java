package com.example.demo;

import java.io.IOException;

import com.example.demo.helpers.RestRequestHelper;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {
  String optimizelyToken = "2:xROnoOD3aokAZi0QooRa5trrlMql0OPrz6QSzmiyNl-LRBtmzsMs";

  @Test
  void getFullUserGroup() throws IOException {
    String urlString = "https://www.compass.com/api/v3/audience_mapper/get_user_groups_by_email/";
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    String requestBody = "{}";
    restHelper.setRequestBody(requestBody);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    System.out.println(jsonResponse);
  }

  @Test
  void getSpecificUser() throws IOException {
    String urlString = "https://www.compass.com/api/v3/audience_mapper/get_user_groups_by_email/";
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    String requestBody = "{\"email\":\"mike.anastasia@compass.com\"}";
    restHelper.setRequestBody(requestBody);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    System.out.println(jsonResponse);
  }

  @Test
  void getFeature() throws IOException {
    String featureId = "18879920455";
    String urlString = "https://api.optimizely.com/v2/features/" + featureId;
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    restHelper.setRequestProperty("Authorization", "Bearer " + optimizelyToken);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    System.out.println(jsonResponse);
  }
}

