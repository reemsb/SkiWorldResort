package tn.esprit.presentation.mbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Administrator;
import entity.Client;
import entity.Coach;
import entity.User;
import services.AuthentificationServiceLocal;
import services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	AuthentificationServiceLocal AuthentificationServiceLocal;
    private User user = new User();
	private boolean isLogged = false;
	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/SignIn?faces-redirect=true";
	}
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = AuthentificationServiceLocal.login(user.getEmail(), user.getPassword());
		System.out.println("valeur avant if"+userLoggedIn);
		if (userLoggedIn != null) {
			
			user = userLoggedIn;
			System.out.println(user.getEmail());
			if (userLoggedIn instanceof Client) {
				return navigateTo = "/Client?faces-redirect=true";
				//System.out.println("ena client"+user.getEmail());

			} else if (userLoggedIn instanceof Coach) {
				return navigateTo = "/Coach?faces-redirect=true";
			}
			} else {
			System.err.println("not");
		}
			return navigateTo="/SignIn?faces-redirect=true";
	
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

}
