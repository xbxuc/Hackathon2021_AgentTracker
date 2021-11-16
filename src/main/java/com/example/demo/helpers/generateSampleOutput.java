package com.example.demo.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class generateSampleOutput {
  public static TreeMap<String, ArrayList<String>> getSampleOutputForUser(){
    TreeMap<String, ArrayList<String>> output = new TreeMap<>();
    output.put("belongsToUserGroups", new ArrayList<String>(
        Arrays.asList("MA Agents",
            "CRM Team")));
    output.put("EA Test Feature 1", new ArrayList<String>(
        Arrays.asList("UserGroup Foo1",
            "CRM Team",
            "NY Agents" )));
    output.put("EA Test Feature 2", new ArrayList<String>(
        Arrays.asList("UserGroup Foo2",
            "CRM Team 2",
            "NY Agents 2" )));
    output.put("Feature 3 for everyone", new ArrayList<String>(
        Arrays.asList("Everyone" )));
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
