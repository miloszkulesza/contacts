package com.zadanie.contacts.controllers;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.zadanie.contacts.beans.Address;
import com.zadanie.contacts.beans.Contact;
import com.zadanie.contacts.beans.Email;
import com.zadanie.contacts.beans.Phone;
import com.zadanie.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactsService;

    @GetMapping
    public List<Contact> getContacts(){
        return contactsService.getContacts();
    }

    @PostMapping(value = "/email")
    public void addEmail(@RequestBody Email email)throws IOException {
        contactsService.addEmail(email);
    }

    @GetMapping(value = "/email")
    public Iterable<Email> getEmails(){
        return contactsService.getEmails();
    }

    @GetMapping(value = "/{id}/email")
    public List<Email> getPersonEmails(@PathVariable int id){
        return contactsService.getPersonEmails(id);
    }

    @PutMapping(value = "/email")
    public void updateEmail(@RequestBody Email email){
        contactsService.updateEmail(email);
    }

    @DeleteMapping(value = "/email/{id}")
    public void removeEmail(@PathVariable int id){
        contactsService.removeEmail(id);
    }

    @PostMapping(value = "/phone")
    public void addPhone(@RequestBody Phone phone)throws IOException{
        contactsService.addPhone(phone);
    }

    @GetMapping(value = "/phone")
    public Iterable<Phone> getPhones(){
        return contactsService.getPhones();
    }

    @DeleteMapping(value = "/phone/{id}")
    public void removePhone(@PathVariable int id){
        contactsService.removePhone(id);
    }

    @PutMapping(value = "/phone")
    public void updatePhone(@RequestBody Phone phone){
        contactsService.updatePhone(phone);
    }

    @GetMapping(value = "/{id}/phone")
    public Iterable<Phone> getPersonPhones(@PathVariable int id){
        return contactsService.getPersonPhones(id);
    }

    @PostMapping(value = "/address")
    public void addAddress(@RequestBody Address address) {
        contactsService.addAddress(address);
    }

    @GetMapping(value = "/address")
    public Iterable<Address> getAddresses(){
        return contactsService.getAddresses();
    }

    @GetMapping(value = "/{id}/address")
    public List<Address> getPersonAddresses(@PathVariable int id){
        return contactsService.getPersonAddresses(id);
    }

    @DeleteMapping(value = "/address/{id}")
    public void removeAddress(@PathVariable int id){
        contactsService.removeAddress(id);
    }

    @PutMapping(value = "/address")
    public void updateAddress(@RequestBody Address address){
        contactsService.updateAddress(address);
    }

    @GetMapping(value = "/{id}")
    public List<Contact> getPersonContact(@PathVariable int id){
        return contactsService.getPersonContact(id);
    }

    @GetMapping(value = "/{personid}/email/{emailid}")
    public Email getOneEmail(@PathVariable int personid, @PathVariable int emailid){
        return contactsService.getOneEmail(personid, emailid);
    }

    @GetMapping(value = "/{personid}/phone/{phoneid}")
    public Phone getOnePhone(@PathVariable int personid, @PathVariable int phoneid){
        return contactsService.getOnePhone(personid, phoneid);
    }

    @GetMapping(value = "/{personid}/address/{addressid}")
    public Address getOneAddress(@PathVariable int personid, @PathVariable int addressid){
        return contactsService.getOneAddress(personid, addressid);
    }
}
