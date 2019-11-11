package com.codeTest.dataLayer.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeTest.dataLayer.response.DataLayerResponse;
import com.codeTest.dataLayer.response.DataLayerResponseWithList;
import com.codeTest.dataLayer.service.DataLayerService;

@RestController
@RequestMapping(value = "person")
public class DataLayerController {

  @Autowired
  DataLayerService service;

  @PostMapping(value = "/add")
  public ResponseEntity<DataLayerResponse> addPerson(@RequestBody String user) {
    DataLayerResponse response = service.addPerson(user);


    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping(value = "/edit/{id}")
  public ResponseEntity<DataLayerResponse> editPerson(@PathVariable int id,
      @RequestBody String user) throws ParseException {
    JSONParser parse = new JSONParser();
    JSONObject userObj = (JSONObject) parse.parse(user);
    DataLayerResponse response = service.editPerson(id, userObj);


    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = "/count")
  public ResponseEntity<DataLayerResponse> getPersonCount() {
    DataLayerResponse response = service.countPerson();


    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = "/list")
  public ResponseEntity<DataLayerResponseWithList> getPersonList() {
    DataLayerResponseWithList response = service.listOfPerson();
    return new ResponseEntity<>(response, HttpStatus.OK);

  }

  @PostMapping(value = "/delete/{id}")
  public ResponseEntity<DataLayerResponse> deletePerson(@PathVariable int id) {
    DataLayerResponse response = service.deletePerson(id);


    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
