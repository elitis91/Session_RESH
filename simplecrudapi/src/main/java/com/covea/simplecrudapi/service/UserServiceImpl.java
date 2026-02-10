package com.covea.simplecrudapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covea.simplecrudapi.dao.UserDAO;
import com.covea.simplecrudapi.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public User generateApikey(String username) {
		return userDAO.save(new User(username));
	}

	@Override
	public Boolean isValidApikey(String apikey) {
		Optional<User> key = userDAO.findByApikey(apikey);
		return key.isPresent();
	}
	
	
	

}
