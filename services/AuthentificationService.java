package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.User;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
@LocalBean
public class AuthentificationService implements AuthentificationServiceRemote, AuthentificationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AuthentificationService() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public User login(String email, String password) {
		User user = null;
		try {
			user = (User) entityManager.createQuery("select u from User u where u.email=:param1 and u.password=:param2")
					.setParameter("param1", email).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;
	}
}
