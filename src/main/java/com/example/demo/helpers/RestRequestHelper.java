package com.example.demo.helpers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RestRequestHelper {
  public HttpURLConnection conn;
  public String rawResponse;

  public RestRequestHelper(String urlString) throws IOException {
    URL url = new URL(urlString);
    this.conn = (HttpURLConnection)url.openConnection();
    this.conn.setRequestProperty("Accept", "application/json");
    this.conn.setRequestProperty("Content-Type", "application/json");
    this.conn.setRequestMethod("GET"); // GET as default
  }

  public void setRequestMethod(String type) throws ProtocolException {
    conn.setRequestMethod(type);
  }

  public void setAuthorization(String authString) {
    conn.setRequestProperty("Authorization", authString);
  }

  public void setRequestProperty(String key, String value) {
    conn.setRequestProperty(key, value);
  }

  public void setRequestBody(String requestBody) throws IOException {
    conn.setDoOutput(true);
    try (OutputStream os = conn.getOutputStream()) {
      byte[] input = requestBody.getBytes("utf-8");
      os.write(input, 0, input.length);
    }
  }

  public String fetchRawResponse() throws IOException {
    if (conn.getResponseCode() == 200 || conn.getResponseCode() == 201) {
      BufferedReader br = new BufferedReader(new InputStreamReader(
          (conn.getInputStream())));
      String line;
      while ((line = br.readLine()) != null) {
        rawResponse += line;
      }
    } else {
      String line;
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      while ((line = br.readLine()) != null) {
        rawResponse += line;
      }
    }

    if (rawResponse.substring(0, 4).equals("null")) {
      rawResponse = rawResponse.substring(4);
    }
    return rawResponse;
  }

  public JsonObject fetchJsonResponse() throws IOException {
    String rawResponse = fetchRawResponse();
    return new JsonParser().parse(rawResponse).getAsJsonObject();
  }

  public int getResponseCode() throws IOException {
    return conn.getResponseCode();
  }
}
