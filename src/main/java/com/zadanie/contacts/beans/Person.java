package com.zadanie.contacts.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.regex.Matcher;

@Entity
public class Person {
    @NotNull
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private int personid;

    @NotNull
    @Getter @Setter
    private String first_name;

    @NotNull
    @Getter @Setter
    private String last_name;

    @NotNull
    @Getter
    private String pesel;

    @NotNull
    @Getter @Setter
    private Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    @Past
    private LocalDate birth;

    public enum Gender {
        MALE, FEMALE
    }

    public Person(){
    }

    public Person(String fn, String ln, String p, Gender g, LocalDate b){
        this.first_name = fn;
        this.last_name = ln;
        this.pesel = p;
        this.birth = b;
        this.gender = g;
    }

    public boolean isVaildPesel(String number){
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(number);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setPesel(String number){
        if(isVaildPesel(number)){
            this.pesel = number;
            return true;
        }
        else{
            return false;
        }
    }
}