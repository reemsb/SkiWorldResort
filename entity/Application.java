package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.EmbeddedId;

/**
 * Entity implementation class for Entity: Participation
 *
 */
@Entity

public class Application implements Serializable {
	private Float Score;
	@EmbeddedId
	private ApplicationID applicationid;
	
	@ManyToOne
	@JoinColumn(name = "idCompetition", referencedColumnName = "id", updatable = false, insertable = false)
	private Competition competition;
	
	@ManyToOne
	@JoinColumn(name = "idClient", referencedColumnName = "id", updatable = false, insertable = false)
	private Client client;
	private static final long serialVersionUID = 1L;

	public Application() {
		super();
	}

	public Application(Float score, Competition competition, Client client) {
		super();
		Score = score;
		this.competition = competition;
		this.client = client;
		this.applicationid= new ApplicationID(competition.getId(),client.getId());
	}

	public ApplicationID getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(ApplicationID applicationid) {
		this.applicationid = applicationid;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationid == null) ? 0 : applicationid.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((competition == null) ? 0 : competition.hashCode());
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
		Application other = (Application) obj;
		if (applicationid == null) {
			if (other.applicationid != null)
				return false;
		} else if (!applicationid.equals(other.applicationid))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (competition == null) {
			if (other.competition != null)
				return false;
		} else if (!competition.equals(other.competition))
			return false;
		return true;
	}

	public Application(Float score, ApplicationID applicationid) {
		super();
		Score = score;
		this.applicationid = applicationid;
		
	}   


}
