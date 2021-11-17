package com.example.demo.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class generateSampleOutput {
  public static TreeMap<String, ArrayList<String>> getSampleOutputForUser(String email) {
    TreeMap<String, ArrayList<String>> output = new TreeMap<>();
    if (email.equals("testEmail")) {
      output.put("belongsToUserGroups", new ArrayList<String>(
          Arrays.asList("MA Agents",
              "CRM Team")));
      output.put("EA Test Feature 1", new ArrayList<String>(
          Arrays.asList("UserGroup Foo1",
              "CRM Team",
              "NY Agents")));
      output.put("EA Test Feature 2", new ArrayList<String>(
          Arrays.asList("UserGroup Foo2",
              "CRM Team 2",
              "NY Agents 2")));
      output.put("Feature 3 for everyone", new ArrayList<String>(
          Arrays.asList("Everyone")));
    } else if (email.equals("amy.harbeck@compass.com")) {
      output.put("belongsToUserGroups", new ArrayList<String>(
          Arrays.asList("New Compass Search - CCIMLS",
              "MC Mailgun Warmup",
              "Kinlin Grover Agents"
          )));
      output.put("Agent Search Web v2 Early Access Mls Source Variables", new ArrayList<String>(
          Arrays.asList("Agent Search Team",
              "New Compass Search - SB Beta",
              "New Compass Search - CCIMLS EA")));
    } else if (email.equals("steven.lin@compass.com")) {
      output.put("belongsToUserGroups", new ArrayList<String>(
          Arrays.asList("EarlyAccess_Required_Internalgroup",
              "marketing_center_ea_prod",
              "Quick Capture Video EA"
          )));
      output.put("VMR Early Access", new ArrayList<String>(
          Arrays.asList("EarlyAccess_Required_Internalgroup",
              "VMR_by geo EA_20211115")));
      output.put("video_messaging_video_caching", new ArrayList<String>(
          Arrays.asList("Quick Capture Video EA")));
    } else if (email.equals("robert.shields@compass.com")) {
      output.put("belongsToUserGroups", new ArrayList<String>(
          Arrays.asList("MC Homepage TB One Sheet",
              "MC Homepage TB Brochure",
              "Realist Beta Group: Chicago",
              "cicero_ea_group_editor_20211011",
              "EarlyAccess_Required_Internalgroup"
          )));
      output.put("VMR Early Access", new ArrayList<String>(
          Arrays.asList("EarlyAccess_Required_Internalgroup",
              "VMR_by geo EA_20211115")));
    }
    return output;
  }

  public static TreeMap<String, ArrayList<String>> getSampleOutputForFeature() {
    TreeMap<String, ArrayList<String>> output = new TreeMap<>();
    output.put("UserGroup1", new ArrayList<String>(
        Arrays.asList("user_aaa@compass.com",
            "user_bbb@outlook.com",
            "user_ccc@gmail.com" )));
    output.put("UserGroup2", new ArrayList<String>(
        Arrays.asList("user_aaa@compass.com",
            "user_bbb@outlook.com",
            "user_ccc@gmail.com" )));
    output.put("UserGroup3", new ArrayList<String>(
        Arrays.asList("Everyone" )));
    return output;
  }
}
