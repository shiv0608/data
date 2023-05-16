package com.reglog.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reglog.entity.Role;
import com.reglog.entity.User;
import com.reglog.repository.UserRepository;


@Service
public class UserDetailsServiceimp implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		  User user = userRepository.findByEmail(email);

	        if (user != null) {
	            return new org.springframework.security.core.userdetails.User(user.getEmail(),
	                    user.getPassword(),
	                    mapRolesToAuthorities(user.getRoles()));
	        }else{
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	    }
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
		 Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	        return mapRoles;
	}
	}

