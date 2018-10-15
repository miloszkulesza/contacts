package com.zadanie.contacts.controllers;

import com.zadanie.contacts.beans.Person;
import com.zadanie.contacts.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> getPeople(){
        return personService.getPeople();
    }

    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable int id){
        return personService.getPerson(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @PutMapping
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }

}
