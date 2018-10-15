package com.zadanie.contacts.repositories;

import com.zadanie.contacts.beans.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer> {
    @Query(value = "select * from email e where e.personid = :id", nativeQuery = true)
    List<Email> findByPersonId(@Param("id") int id);

    @Query(value = "select * from email e where e.personid = :personid and e.emailid = :emailid", nativeQuery = true)
    Email getOneEmail(@Param("personid")int personid, @Param("emailid")int emailid);
}
