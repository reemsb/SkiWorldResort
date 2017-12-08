package tn.esprit.presentation.mbean;

import java.util.List;
import java.util.ArrayList;

import services.ApplicationServiceLocal;
import services.CompetitionServiceLocal;
import services.StationServiceLocal;
import services.UserServiceLocal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import entity.Application;
import entity.Client;
import entity.Competition;
import entity.SkiStation;
@ManagedBean
@SessionScoped

public class ApplicationManagementBean {
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
@EJB
private CompetitionServiceLocal CompetitionServiceLocal;
Competition competitionSelected = new Competition();


@EJB
private ApplicationServiceLocal ApplicationServiceLocal;
Application application = new Application();
private List<Application> applicationsByClient=new ArrayList<>();

@EJB
private StationServiceLocal stationServiceLocal;
SkiStation station=new SkiStation();

@EJB 
private UserServiceLocal userServiceLocal;
Client client=new Client();

private List<Competition> allCompetitions =new ArrayList<>();


public List<Competition> getAllCompetitions() {
	allCompetitions = CompetitionServiceLocal.findAllCompetitions();
	return allCompetitions;
}
public void setAllCompetitions(List<Competition> allCompetitions) {
	this.allCompetitions = allCompetitions;
}
public SkiStation getStation() {
	return station;
}
public void setStation(SkiStation station) {
	this.station = station;
}


public void doAddapplication(Competition competition)
{  
	client= (Client) identity.getUser();
	//applicationsByClient=ApplicationServiceLocal.findApplicationById(competition,client);
	//if((applicationsByClient.size()==0)&& (competition.getCapacity()!=0)){

	ApplicationServiceLocal.addApplication(0,competition,client);
	competitionSelected = competition;
	System.out.println("course selected is:"+competitionSelected.getType());
	competition.setCapacity(competitionSelected.getCapacity()-1);
	client.setCosts((float) (80.5+15));
	
CompetitionServiceLocal.updateCompetition(competition);
userServiceLocal.updateUser(client);

}

public Identity getIdentity() {
	return identity;
}
public void setIdentity(Identity identity) {
	this.identity = identity;
}
public Competition getCompetitionSelected() {
	return competitionSelected;
}
public void setCompetitionSelected(Competition competitionSelected) {
	this.competitionSelected = competitionSelected;
}
public CompetitionServiceLocal getCompetitionServiceLocal() {
	return CompetitionServiceLocal;
}
public void setCompetitionServiceLocal(CompetitionServiceLocal competitionServiceLocal) {
	CompetitionServiceLocal = competitionServiceLocal;
}
public ApplicationServiceLocal getApplicationServiceLocal() {
	return ApplicationServiceLocal;
}
public void setApplicationServiceLocal(ApplicationServiceLocal applicationServiceLocal) {
	ApplicationServiceLocal = applicationServiceLocal;
}
public List<Application> getApplicationsByClient() {
	return applicationsByClient;
}
public void setApplicationsByClient(List<Application> applicationsByClient) {
	this.applicationsByClient = applicationsByClient;
}
public UserServiceLocal getUserServiceLocal() {
	return userServiceLocal;
}
public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
	this.userServiceLocal = userServiceLocal;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}

}