package services;

import javax.ejb.Local;

import entity.Client;
import entity.User;

@Local
public interface UserServiceLocal {

	 boolean addCoach ( User u);
	 public User findUserById(Integer id) ;
	 public void addUser(User c1) ;
	void updateUser(Client client);
			
}
