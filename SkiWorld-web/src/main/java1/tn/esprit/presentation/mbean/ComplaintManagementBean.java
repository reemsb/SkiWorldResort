package tn.esprit.presentation.mbean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Client;
import entity.Complaint;
import entity.ComplaintID;
import entity.SkiStation;
import services.ComplaintServiceLocal;
import services.StationServiceLocal;
import services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class ComplaintManagementBean {
	 
	@EJB
	private ComplaintServiceLocal complaintServiceLocal;
	private Complaint complaintSelected=new Complaint();
	private Complaint complaint=new Complaint();
	@EJB
	private UserServiceLocal userServiceLocal;
	private Client client=new Client();
	
	@EJB
	  private StationServiceLocal stationServiceLocal;
	    private SkiStation station =new SkiStation();    

	   
	private String topic;
	private Date dateReclamation;
    

	
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    
   
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    
   
	public Date getDateReclamation() {
    	dateReclamation=new Date();
		return dateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		
		this.dateReclamation = dateReclamation;
	}
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
	
	
public void doAddComplaint()
    {  		client=(Client) identity.getUser();
          System.out.print(client.getNom());
          station=stationServiceLocal.findStationById(2);
          complaintServiceLocal.addComplaint(station,client,"risky for kids","not dealt with");
          complaintSelected = complaint;
        System.out.println("complaint ajoute "+complaintSelected.getStatus());	 

    }
	//complaints by clients afff
	private List<Complaint> complaintsbyclient =new ArrayList<>();

	public List<Complaint> getComplaintsbyclient() {
    	client= (Client) identity.getUser();
		complaintsbyclient=complaintServiceLocal.findAllComplaintsByClient(client);
		return complaintsbyclient;
	}
	public void setComplaintsbyclient(List<Complaint> complaintsbyclient) {
		this.complaintsbyclient = complaintsbyclient;
	}
	
	
	
	
	
	public void doDeleteComplaint(Complaint complaintSelected)
	{ //complaint=complaintSelected;

		complaintServiceLocal.deleteComplaint(complaintSelected);
	}

	
	
	
    public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public ComplaintServiceLocal getComplaintServiceLocal() {
		return complaintServiceLocal;
	}
	public void setComplaintServiceLocal(ComplaintServiceLocal complaintServiceLocal) {
		this.complaintServiceLocal = complaintServiceLocal;
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
	public StationServiceLocal getStationServiceLocal() {
		return stationServiceLocal;
	}
	public void setStationServiceLocal(StationServiceLocal stationServiceLocal) {
		this.stationServiceLocal = stationServiceLocal;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
  
	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public SkiStation getStation() {
		return station;
	}
	public void setStation(SkiStation station) {
		this.station = station;
	}
	public Complaint getComplaintSelected() {
		return complaintSelected;
	}
	public void setComplaintSelected(Complaint complaintSelected) {
		this.complaintSelected = complaintSelected;
	}
	
 
    
 
    
}
