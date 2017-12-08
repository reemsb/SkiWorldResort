package services;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface AuthentificationServiceRemote {
	public User login(String email, String password);
}
