package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Complaint
 *
 */
@Entity

public class Complaint implements Serializable {
	@EmbeddedId 
	private ComplaintID complaintID;
	private String topic;
	private String status;
	@ManyToOne
	@JoinColumn(name = "idStation", referencedColumnName = "id", updatable = false, insertable = false)
	private SkiStation station;
	
	@ManyToOne
	@JoinColumn(name = "idClient", referencedColumnName = "id", updatable = false, insertable = false)
	private Client client;
	
	private static final long serialVersionUID = 1L;

	public Complaint() {
		super();
	}

	public Complaint(String topic, String status, SkiStation station, Client client) {
		super();
		this.complaintID=new ComplaintID(station.getId(),client.getId());
		this.topic = topic;
		this.status = status;
		this.station = station;
		this.client = client;
	}

	public Complaint(ComplaintID complaintID, String topic, String status) {
		super();
		this.complaintID = complaintID;
		this.topic = topic;
		this.status = status;
	}

	public ComplaintID getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(ComplaintID complaintID) {
		this.complaintID = complaintID;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SkiStation getStation() {
		return station;
	}

	public void setStation(SkiStation station) {
		this.station = station;
	}

	
	

	}
