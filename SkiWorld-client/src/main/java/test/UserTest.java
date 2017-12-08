package test;

import buisinessdelegate.UserServiceDelegate;
import entity.Client;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hhh");
		Client client=(Client) UserServiceDelegate.dofindClientById(1);
		System.out.println(client.getNom());
	}

}
