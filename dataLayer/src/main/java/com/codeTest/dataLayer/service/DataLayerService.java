package com.codeTest.dataLayer.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeTest.dataLayer.entity.Person;
import com.codeTest.dataLayer.repository.PersonRepository;
import com.codeTest.dataLayer.response.DataLayerResponse;
import com.codeTest.dataLayer.response.DataLayerResponseWithList;

@Service
public class DataLayerService {

  @Autowired
  PersonRepository repository;

  public DataLayerResponse addPerson(String userDetails) {
    String[] userArr = userDetails.split(",");
    int userId = Integer.parseInt(userArr[0]);

    if (!getPerson(userId)) {
      Person person = new Person(userId, userArr[1], userArr[2]);

      Person res = repository.insert(person);

      if (res != null) {
        return new DataLayerResponse("Person inserted with userId " + res.getUserId(), true, 1);
      }
      return new DataLayerResponse("Person not added ", false, 0);
    } else {
      return new DataLayerResponse("User id already exist, enter another value ", false, 0);
    }
  }

  public boolean getPerson(int id) {


    Optional<Person> res = repository.findById(id);

    if (res.isPresent()) {
      return true;
    }
    return false;
  }

  public DataLayerResponse editPerson(int userId, Map<String, String> userDetails) {
    if (getPerson(userId)) {

      Person user = repository.findById(userId).get();
      if (userDetails.containsKey("firstName"))
        user.setFirstName(userDetails.get("firstName"));

      else if (userDetails.containsKey("lastName"))
        user.setLastName(userDetails.get("lastName"));

      Person res = repository.save(user);
      if (res != null) {
        return new DataLayerResponse("Person details updated with userId " + res.getUserId(), true,
            1);
      }
      return new DataLayerResponse("Person not updated ", false, 0);
    } else {
      return new DataLayerResponse(
          "Person with userId " + userId + " doesn't exist , Please check the userId", false, 0);
    }
  }

  public DataLayerResponse countPerson() {
    long count = repository.count();
    return new DataLayerResponse("Count of persons are :" + count, true, count);

  }



  public DataLayerResponseWithList listOfPerson() {

    List<Person> personList = repository.findAll();
    int size = personList.size();
    if (personList != null && size > 0) {
      return new DataLayerResponseWithList("List of " + size + " persons retreived ", true, size,
          personList);
    }
    return new DataLayerResponseWithList("No list of Person retreived ", false, size, personList);
  }

  public DataLayerResponse deletePerson(int id) {

    repository.deleteById(id);

    return new DataLayerResponse("Person deleted with id: " + id, false, 1);
  }

}
