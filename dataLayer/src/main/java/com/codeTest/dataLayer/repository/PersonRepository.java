package com.codeTest.dataLayer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeTest.dataLayer.entity.Person;

public interface PersonRepository extends MongoRepository<Person, Integer> {

}
