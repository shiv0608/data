package com.reglog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.reglog.dto.UserDto;
import com.reglog.entity.User;
import com.reglog.service.UserService;





@Controller
public class ReglogCont {
	private UserService userService;

	public ReglogCont(UserService userService) {
		super();
		this.userService = userService;
	}
	
	 @GetMapping("index")
	    public String home(){
	        return "index";
	    }

	    @GetMapping("/login")
	    public String loginForm() {
	        return "login";
	    }
	    
	
	    
	    @GetMapping("register")
	    public String showRegistrationForm(Model model){
	        UserDto user = new UserDto();
	        model.addAttribute("user", user);
	        return "register";
	    }
	    
	    @PostMapping("/register/save")
	    public String registration(@Valid @ModelAttribute("user") UserDto user,
	                               BindingResult result,
	                               Model model){
	        User existing = userService.findByEmail(user.getEmail());
	        if (existing != null) {
	            result.rejectValue("email", null, "There is already an account registered with that email");
	        }
	        if (result.hasErrors()) {
	            model.addAttribute("user", user);
	            return "register";
	        }
	        userService.saveUser(user);
	        return "redirect:/register?success";
	    }
	    @GetMapping("/users")
	    public String listRegisteredUsers(Model model){
	        List<UserDto> users = userService.findAllUsers();
	        model.addAttribute("users", users);
	        return "users";
	    }

}
