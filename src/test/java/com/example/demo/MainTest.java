package com.example.demo;

import java.io.IOException;

import com.example.demo.helpers.DataRetriever;
import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {
  @Test
  void getFullUserGroup() throws IOException {
    JsonArray allUserGroups = DataRetriever.getFullUserGroup();
    System.out.println(allUserGroups);
  }

  @Test
  void getSpecificUserTest() throws IOException {
    String email = "mike.anastasia@compass.com";
    JsonArray userGroups = DataRetriever.getUserByEmail(email);
    System.out.println(userGroups);
  }

  @Test
  void getFeatureTest() throws IOException {
    String featureId = "18879920455";
    System.out.println(DataRetriever.getAudiencesByFeatureID(featureId));
  }

  @Test
  void getUserGroupsTest() throws IOException {
    String audienceId = "19335421540";
    System.out.println(DataRetriever.getUserGroupsByAudienceID(audienceId));
  }
}

