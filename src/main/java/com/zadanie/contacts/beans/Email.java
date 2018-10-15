package com.zadanie.contacts.beans;

import lombok.Getter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Email extends Contact{
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int emailid;

    @Getter
    private String email;

    @JoinTable(name = "person")
    @NotNull
    @Getter
    private int personid;

    public Email(){

    }

    public Email(String email, int personid){
        this.email = email;
        this.personid = personid;
    }

    public String getEmail(){
            return this.email;
    }

    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public boolean setEmail(String email){
        if(isValidEmailAddress(email)){
            this.email = email;
            return true;
        }
        else{
            return false;
        }
    }
}
