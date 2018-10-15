package com.zadanie.contacts.services;

import com.zadanie.contacts.beans.Person;
import com.zadanie.contacts.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    public Person getPerson(int id){
        return personRepository.findById(id).get();
    }

    public void addPerson(Person person){
        if(person.isVaildPesel(person.getPesel()))
            personRepository.save(person);
    }

    public void updatePerson(Person person){
        if(person.isVaildPesel(person.getPesel()))
            personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

}
