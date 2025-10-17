package com.example.demo.DaoLayers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.ContactDetails;

@Repository
public interface ContactDetailsDao extends JpaRepository<ContactDetails, Integer>{
	
	List<ContactDetails> findByUsername(String name);

}
