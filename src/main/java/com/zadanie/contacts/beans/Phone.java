package com.zadanie.contacts.beans;


import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Phone extends Contact{
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int phoneid;

    @Getter
    @NotNull
    private String phone_number;

    @JoinTable(name = "person")
    @NotNull
    @Getter
    private int personid;

    public Phone(){

    }

    public Phone(String number, int personid){
        this.phone_number = number;
        this.personid = personid;
    }

    public boolean isValidPhoneNumber(String number){
        Pattern pattern = Pattern.compile("\\d{9}");
        Matcher matcher = pattern.matcher(number);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setPhoneNumber(String number){
        if(isValidPhoneNumber(number)){
            this.phone_number = number;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setPersonid(int id){
        if((id >= 0)){
            this.personid = id;
            return true;
        }
        else{
            return false;
        }
    }
}
