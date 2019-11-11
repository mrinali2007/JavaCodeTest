package com.java.codeTest.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PersonDetailService {

  private String api = "http://localhost:8080/person";
  private String getPersonListURL = "/list";
  private String getPersonCountURL = "/count";
  private String addPersonURL = "/add";
  private String deletePersonListURL = "/delete/%s";
  private String editPersonURL = "/edit/%s";

  public JSONObject getPersonsList() throws Exception {
    JSONObject obj = new JSONObject();
    URL uri = new URL(api + getPersonListURL);
    HttpURLConnection http = (HttpURLConnection) uri.openConnection();
    http.setRequestMethod("GET");
    http.setRequestProperty("Content-Type", "application/json; utf-8");
    http.setRequestProperty("Accept", "application/json");
    http.connect();
    // JSONObject obj = null;
    if (http.getResponseCode() == 200) {
      try (BufferedReader br =
          new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String res = null;
        while ((res = br.readLine()) != null) {
          response.append(res.trim());
        }
        JSONParser parse = new JSONParser();
        obj = (JSONObject) parse.parse(response.toString());
      }
    } else {
      obj.put("message", "Operation is not sucessfull, due to this error:"
          + http.getResponseMessage() + "\n status code:" + http.getResponseCode());
    }

    return obj;

  }

  public JSONObject addPerson(String user) throws Exception {
    JSONObject obj = new JSONObject();
    URL uri = new URL(api + addPersonURL);
    HttpURLConnection http = (HttpURLConnection) uri.openConnection();
    http.setRequestMethod("POST");
    http.setRequestProperty("Content-Type", "application/json; utf-8");
    http.setRequestProperty("Accept", "application/json");
    http.setDoOutput(true);
    try (OutputStream os = http.getOutputStream()) {
      byte[] input = user.getBytes("utf-8");
      os.write(input, 0, input.length);
    }
    http.connect();
    // JSONObject obj = null;
    if (http.getResponseCode() == 200) {
      try (BufferedReader br =
          new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String res = null;
        while ((res = br.readLine()) != null) {
          response.append(res.trim());
        }
        JSONParser parse = new JSONParser();
        obj = (JSONObject) parse.parse(response.toString());
      }
    } else {
      obj.put("message", "Operation is not sucessfull, due to this error:"
          + http.getResponseMessage() + "\n status code:" + http.getResponseCode());
    }
    return obj;

  }

  public JSONObject editPerson(int id, String userDetails) throws Exception {
    JSONObject obj = new JSONObject();
    URL uri = new URL(api + String.format(editPersonURL, String.valueOf(id)));
    HttpURLConnection http = (HttpURLConnection) uri.openConnection();
    http.setRequestMethod("PUT");
    http.setRequestProperty("Content-Type", "application/json; utf-8");
    http.setRequestProperty("Accept", "application/json");
    http.setDoOutput(true);
    try (OutputStream os = http.getOutputStream()) {
      byte[] input = userDetails.getBytes("utf-8");
      os.write(input, 0, input.length);
    }
    http.connect();
    // JSONObject obj = null;
    if (http.getResponseCode() == 200) {
      try (BufferedReader br =
          new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String res = null;
        while ((res = br.readLine()) != null) {
          response.append(res.trim());
        }
        JSONParser parse = new JSONParser();
        obj = (JSONObject) parse.parse(response.toString());
      }
    } else {
      obj.put("message", "Operation is not sucessfull, due to this error:"
          + http.getResponseMessage() + "\n status code:" + http.getResponseCode());
    }
    return obj;


  }

  public JSONObject personCount() {
    JSONObject obj = new JSONObject();
    try {
      URL uri = new URL(api + getPersonCountURL);
      HttpURLConnection http = (HttpURLConnection) uri.openConnection();
      http.setRequestMethod("GET");
      http.setRequestProperty("Content-Type", "application/json; utf-8");
      http.setRequestProperty("Accept", "application/json");
      http.connect();

      if (http.getResponseCode() == 200) {
        try (BufferedReader br =
            new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
          StringBuilder response = new StringBuilder();
          String res = null;
          while ((res = br.readLine()) != null) {
            response.append(res.trim());
          }
          JSONParser parse = new JSONParser();
          obj = (JSONObject) parse.parse(response.toString());
        }
      } else {
        obj.put("message", "Operation is not sucessfull, due to this error:"
            + http.getResponseMessage() + "\n status code:" + http.getResponseCode());
      }
    } catch (Exception ex) {
      obj.put("message", "There is a exception :" + ex.getMessage());
    }
    return obj;

  }

  public JSONObject deletePerson(int userId) throws Exception {
    JSONObject obj = new JSONObject();
    URL uri = new URL(api + String.format(deletePersonListURL, userId));
    HttpURLConnection http = (HttpURLConnection) uri.openConnection();
    http.setRequestMethod("POST");
    http.setRequestProperty("Content-Type", "application/json; utf-8");
    http.setRequestProperty("Accept", "application/json");
    http.setDoOutput(true);
    http.connect();
    // JSONObject obj = null;
    if (http.getResponseCode() == 200) {
      try (BufferedReader br =
          new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String res = null;
        while ((res = br.readLine()) != null) {
          response.append(res.trim());
        }
        JSONParser parse = new JSONParser();
        obj = (JSONObject) parse.parse(response.toString());
      }
    } else {
      obj.put("message", "Operation is not sucessfull, due to this error:"
          + http.getResponseMessage() + "\n status code:" + http.getResponseCode());
    }
    return obj;

  }


}
