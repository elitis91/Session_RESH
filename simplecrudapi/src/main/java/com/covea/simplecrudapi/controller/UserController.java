package com.covea.simplecrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covea.simplecrudapi.models.User;
import com.covea.simplecrudapi.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "", produces="application/json")
	public ResponseEntity<?> generateApikey(@RequestParam String username){
		User _user = userService.generateApikey(username);
		return new ResponseEntity<User>(_user,HttpStatus.CREATED);
	}

}
