package com.zadanie.contacts.repositories;

import com.zadanie.contacts.beans.Email;
import com.zadanie.contacts.beans.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
    @Query(value = "select * from phone e where e.personid = :id", nativeQuery = true)
    List<Phone> findByPersonId(@Param("id") int id);

    @Query(value = "select * from phone e where e.personid = :personid and e.phoneid = :phoneid", nativeQuery = true)
    Phone getOnePhone(@Param("personid")int personid, @Param("phoneid")int phoneid);
}
