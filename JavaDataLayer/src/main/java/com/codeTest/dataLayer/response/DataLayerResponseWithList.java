package com.codeTest.dataLayer.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codeTest.dataLayer.entity.Person;

public class DataLayerResponseWithList {

  public List<Map<String, Object>> personList;
  public String message;
  public boolean success = false;

  public DataLayerResponseWithList(String message, boolean success, long result,
      List<Person> matchList) {
    this.message = message;
    this.success = success;
    this.personList = conversion(matchList);
  }

  public List<Map<String, Object>> conversion(List<Person> persons) {
    List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();
    for (Person entity : persons) {
      Map<String, Object> obj = new HashMap<String, Object>();
      obj.put("userId", entity.getUserId());
      obj.put("firstName", entity.getFirstName());
      obj.put("lastName", entity.getLastName());
      li.add(obj);
    }
    return li;
  }
}
