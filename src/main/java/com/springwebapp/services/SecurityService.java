package com.springwebapp.services;

public interface SecurityService {

	public String findLoggedInUsername();
	
	public void autologin(String username, String password);
}
