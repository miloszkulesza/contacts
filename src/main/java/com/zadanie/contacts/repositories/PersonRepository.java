package com.zadanie.contacts.repositories;

import com.zadanie.contacts.beans.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {

}
