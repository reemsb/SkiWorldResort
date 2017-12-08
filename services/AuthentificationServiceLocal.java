package services;

import javax.ejb.Local;

import entity.User;

@Local
public interface AuthentificationServiceLocal {
	public User login(String email, String password);
	
}
