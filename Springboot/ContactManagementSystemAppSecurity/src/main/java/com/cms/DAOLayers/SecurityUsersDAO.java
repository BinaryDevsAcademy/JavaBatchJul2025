package com.cms.DAOLayers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.entities.SecurityUsers;

@Repository
public interface SecurityUsersDAO extends JpaRepository<SecurityUsers, Integer>{

	SecurityUsers findByUserEmail(String username);
	
	@Query("SELECT u.userRole FROM SecurityUsers AS u WHERE u.userEmail = :username")
	String findRoleByUsername(String username);

}
