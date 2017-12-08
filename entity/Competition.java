package entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompetitionService
 *
 */
@Entity

public class Competition implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer capacity;
	//@Temporal(TemporalType.TIME)
	private java.util.GregorianCalendar StartingHour;
	//@Temporal(TemporalType.TIME)
    private java.util.GregorianCalendar FinishingHour;

	@ManyToOne
	private Administrator Admin;
	@ManyToOne
	private SkiStation station;
	@OneToMany(mappedBy = "competition")
	private List<Application> applications;

	private static final long serialVersionUID = 1L;

	private List<Application> getApplications() {
		return applications;
	}

	private void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Competition() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public GregorianCalendar getStartingHour() {
		return StartingHour;
	}

	public void setStartingHour(GregorianCalendar startingHour) {
		StartingHour = startingHour;
	}

	public GregorianCalendar getFinishingHour() {
		return FinishingHour;
	}

	public void setFinishingHour(GregorianCalendar finishingHour) {
		FinishingHour = finishingHour;
	}

	public Administrator getAdmin() {
		return Admin;
	}

	public void setAdmin(Administrator admin) {
		Admin = admin;
	}

	public SkiStation getStation() {
		return station;
	}

	public void setStation(SkiStation station) {
		this.station = station;
	}

	


	}
