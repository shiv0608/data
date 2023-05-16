package com.reglog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reglog.entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long>{
	 Role findByName(String name);
}
