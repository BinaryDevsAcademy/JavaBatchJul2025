package com.example.demo.DaoLayers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.ContactDetails;

@Repository
public interface ContactDetailsDao extends JpaRepository<ContactDetails, Integer>{

}
