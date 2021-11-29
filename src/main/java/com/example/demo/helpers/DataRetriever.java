package com.example.demo.helpers;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DataRetriever {
  private static String optimizelyToken = "2:xROnoOD3aokAZi0QooRa5trrlMql0OPrz6QSzmiyNl-LRBtmzsMs";

  public static JsonArray getFullUserGroup() throws IOException {
    String urlString = "https://www.compass.com/api/v3/audience_mapper/get_user_groups_by_email/";
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    String requestBody = "{\"email\":\"mike.anastasia@compass.com\"}";
    restHelper.setRequestBody(requestBody);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    if (jsonResponse.get("userGroupList").isJsonNull()) {
      throw new RuntimeException("Unable to retrieve userGroupList.");
    } else {
      return jsonResponse.get("userGroupList").getAsJsonArray();
    }
  }

  public static JsonArray getUserByEmail(String email) throws IOException {
    String urlString = "https://www.compass.com/api/v3/audience_mapper/get_user_groups_by_email/";
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    String requestBody = "{\"email\":\"" + email + "\"}";
    restHelper.setRequestBody(requestBody);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    if (jsonResponse.get("userGroupList").isJsonNull()) {
      throw new RuntimeException("Unable to retrieve userGroupList.");
    } else {
      return jsonResponse.get("userGroupList").getAsJsonArray();
    }
  }

  public static String getAudiencesByFeatureID(String featureId) throws IOException {
    String urlString = "https://api.optimizely.com/v2/features/" + featureId;
    RestRequestHelper restHelper = new RestRequestHelper(urlString);
    restHelper.setRequestMethod("GET");
    restHelper.setRequestProperty("Authorization", "Bearer " + optimizelyToken);
    JsonObject jsonResponse = restHelper.fetchJsonResponse();
    JsonArray rules = jsonResponse.get("environments").getAsJsonObject().get("production")
        .getAsJsonObject().get("rollout_rules").getAsJsonArray();
    String output = rules.get(0).getAsJsonObject().get("audience_conditions").getAsString();
    return output;
  }
}
