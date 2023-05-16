package com.reglog.service;

import java.util.List;

import com.reglog.dto.UserDto;
import com.reglog.entity.User;



public interface UserService {
	void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

}
