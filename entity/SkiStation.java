package entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SkiStation
 *
 */
@Entity

public class SkiStation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer id;
	private String label;
	private long latitude;
	private long longitude;
	private String description;
	@OneToOne (mappedBy="station")
	private StationChief chief;
	@OneToMany (mappedBy=("track"))
	private List<Track> tracks   ;
	@OneToMany (mappedBy=("station"))
	private List<Competition> competitions    ;
	private static final long serialVersionUID = 1L;

	public SkiStation() {
		super();
	}   
	
	public SkiStation(String label, long latitude, long longitude, String description) {
		super();
		this.label = label;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}   
	public long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}   
	public long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SkiStation [label=" + label + ", latitude=" + latitude + ", longitude=" + longitude + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + (int) (latitude ^ (latitude >>> 32));
		result = prime * result + (int) (longitude ^ (longitude >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkiStation other = (SkiStation) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (latitude != other.latitude)
			return false;
		if (longitude != other.longitude)
			return false;
		return true;
	}
   
}
