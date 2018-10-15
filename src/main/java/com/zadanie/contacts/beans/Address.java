package com.zadanie.contacts.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address extends Contact{
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int addressid;

    @NotNull
    @Getter
    @Setter
    private String city;

    @NotNull
    @Getter
    private int buildingNumber;

    @NotNull
    @Getter
    private int localNumber;

    @NotNull
    @Getter
    @Setter
    private String street;

    @JoinTable(name = "person")
    @NotNull
    @Getter
    private int personid;

    public Address(){

    }

    public Address(String city, String street, int buildingNumber, int localNumber, int personid){
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.localNumber = localNumber;
        this.personid = personid;
    }

    public boolean setBuildingNumber(int number){
        if(number > 0) {
            this.buildingNumber = number;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setLocalNumber(int number){
        if(number > 0){
            this.localNumber = number;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setPersonid(int id){
        if(id >= 0){
            this.personid = id;
            return true;
        }
        else{
            return false;
        }
    }
}
