package services;

import javax.ejb.Remote;

import entity.Client;
import entity.User;

@Remote
public interface UserServiceRemote {

	 boolean addCoach ( User u);
	 public User findUserById(Integer id);
	 public void addUser(User c1) ;
}
