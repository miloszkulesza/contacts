package com.zadanie.contacts.repositories;

import com.zadanie.contacts.beans.Address;
import com.zadanie.contacts.beans.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query(value = "select * from address e where e.personid = :id", nativeQuery = true)
    List<Address> findByPersonId(@Param("id") int id);

    @Query(value = "select * from address e where e.personid = :personid and e.addressid = :addressid", nativeQuery = true)
    Address getOneAddress(@Param("personid")int personid, @Param("addressid")int addresid);
}
