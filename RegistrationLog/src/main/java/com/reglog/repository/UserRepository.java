package com.reglog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reglog.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
//	@Query("select u from User u where u.email=:email")
	//public User getUserByUserName(@Param("email") String email);
}
