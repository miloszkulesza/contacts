package com.zadanie.contacts.services;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.zadanie.contacts.beans.Address;
import com.zadanie.contacts.beans.Contact;
import com.zadanie.contacts.beans.Email;
import com.zadanie.contacts.beans.Phone;
import com.zadanie.contacts.repositories.AddressRepository;
import com.zadanie.contacts.repositories.EmailRepository;
import com.zadanie.contacts.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void addEmail(Email email)throws IOException {
        if(email.isValidEmailAddress(email.getEmail()))
            emailRepository.save(email);
        else {
            throw new IOException("Invalid email address");
        }
    }

    public Iterable<Email> getEmails(){
        return emailRepository.findAll();
    }

    public void removeEmail(int id){
        emailRepository.deleteById(id);
    }

    public List<Email> getPersonEmails(int id){
        return emailRepository.findByPersonId(id);
    }

    public void updateEmail(Email email){
        emailRepository.save(email);
    }

    public boolean addPhone(Phone phone)throws IOException{
        if(phone.isValidPhoneNumber(phone.getPhone_number())) {
            phoneRepository.save(phone);
            return true;
        }
        else
            throw new IOException("Invalid phone number");
    }

    public Iterable<Phone> getPhones(){
        return phoneRepository.findAll();
    }

    public List<Phone> getPersonPhones(int id){
        return phoneRepository.findByPersonId(id);
    }

    public void removePhone(int id){
        phoneRepository.deleteById(id);
    }

    public void updatePhone(Phone phone){
        if(phone.isValidPhoneNumber(phone.getPhone_number()))
            phoneRepository.save(phone);
    }

    public void addAddress(Address address){
            addressRepository.save(address);
    }

    public Iterable<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public void removeAddress(int id){
        addressRepository.deleteById(id);
    }

    public List<Address> getPersonAddresses(int id){
        return addressRepository.findByPersonId(id);
    }

    public void updateAddress(Address address){
            addressRepository.save(address);
    }

    public List<Contact> getPersonContact(int id){
        List<Contact> temp = new ArrayList<>();
        emailRepository.findByPersonId(id).forEach(temp::add);
        phoneRepository.findByPersonId(id).forEach(temp::add);
        addressRepository.findByPersonId(id).forEach(temp::add);
        return temp;
    }

    public Email getOneEmail(int personid, int emailid){
        return emailRepository.getOneEmail(personid, emailid);
    }

    public Phone getOnePhone(int personid, int phoneid){
        return phoneRepository.getOnePhone(personid, phoneid);
    }

    public Address getOneAddress(int personid, int addressid){
        return addressRepository.getOneAddress(personid, addressid);
    }

    public List<Contact> getContacts(){
        List<Contact> temp = new ArrayList<>();
        emailRepository.findAll().forEach(temp::add);
        phoneRepository.findAll().forEach(temp::add);
        addressRepository.findAll().forEach(temp::add);
        return temp;
    }
}
