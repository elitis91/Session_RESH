package com.covea.simplecrudapi.service;

import com.covea.simplecrudapi.models.User;

public interface UserService {
	
	User generateApikey(String username);
	
	Boolean isValidApikey(String apikey);

}
