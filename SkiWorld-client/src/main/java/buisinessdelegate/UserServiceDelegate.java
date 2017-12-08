package buisinessdelegate;

import entity.User;
import serviceLocater.ServiceLocator;
import services.UserServiceRemote;

public class UserServiceDelegate {
	private static final String JNDI = "SkiWorld-ear/SkiWorld-ejb/UserService!services.UserService";

	private static UserServiceRemote getProxy() {
		return (UserServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}
	public static User dofindClientById(Integer id) {
		return getProxy().findUserById(id);
	}
}
