package com.selflearnining.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("kevin"),
				isValidPassword = password.equals("dummy");
		
		return isValidUserName && isValidPassword;
	}

}
