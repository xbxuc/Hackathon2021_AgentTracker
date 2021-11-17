package com.example.demo;

import java.util.ArrayList;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.helpers.generateSampleOutput.getSampleOutputForFeature;
import static com.example.demo.helpers.generateSampleOutput.getSampleOutputForUser;

@CrossOrigin("*")
@RestController
public class RestAPIController {

  @GetMapping("/checkAgentByEmail")
  public TreeMap<String, ArrayList<String>> checkAgentByEmail(@RequestParam(value = "email") String email) {
    TreeMap<String, ArrayList<String>> output = new TreeMap<>();
    // Sample Ouput for Front-End development
    output = getSampleOutputForUser(email);

    return output;
  }

  @GetMapping("/checkFeature")
  public TreeMap<String, ArrayList<String>> checkFeature(@RequestParam(value = "feature") String feature) {
    TreeMap<String, ArrayList<String>> output = new TreeMap<>();
    // Sample Ouput for Front-End development
    if (feature.equals("testFeature")){
      output = getSampleOutputForFeature();
    }
    return output;
  }

  @GetMapping("/")
  public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
    return String.format("Hello %s! This is the main page for the Agent Tracker Tool.", name);
  }
}
