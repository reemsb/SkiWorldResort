package services;

import java.util.List;

import javax.ejb.Remote;

import entity.Application;
import entity.Client;
import entity.Competition;

@Remote
public interface ApplicationServiceRemote {
	public void addApplication(Application application);
   	public void deleteApplicationById(Integer comp_id,Integer cl_id);
   	public void updateApplication(Application application);
   	public List<Application> findAllApplication();
      public List<Application> findAllApplicationsByCompetition(Integer id_Competition);
      public List<Application> findAllApplicationsByClient(Integer idClient);
      public List<Client> findAllTopClientsByscoreAndCompetition(Integer id_Competition);
  	public void addApplication(int score, Competition competition, Client client);

}
