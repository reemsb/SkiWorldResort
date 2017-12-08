package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Application;
import entity.Client;
import entity.Competition;

/**
 * Session Bean implementation class ApplicationService
 */
@Stateless
@LocalBean
public class ApplicationService implements ApplicationServiceRemote, ApplicationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ApplicationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addApplication(Application application) {
		// TODO Auto-generated method stub
		entityManager.persist(application);

	}

	

	@Override
	public void deleteApplicationById(Integer comp_id, Integer cl_id) {
		// TODO Auto-generated method stub
       // entityManager.remove(findApplicationById(comp_id,cl_id));

	}

	@Override
	public void updateApplication(Application application) {
		// TODO Auto-generated method stub
        entityManager.merge(application);

	}

	@Override
	public List<Application> findAllApplication() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Application a ",Application.class).getResultList();

	}

	@Override
	public List<Application> findAllApplicationsByCompetition(Integer id_Competition) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Application a where a.idCompetition = :id_Competition ",Application.class).setParameter("id_competition",id_Competition).getResultList();
	}

	@Override
	public List<Application> findAllApplicationsByClient(Integer idClient) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Application a where a.idClient=:idClient",Application.class).setParameter("id_competition",idClient).getResultList();
	}

	@Override
	public List<Client> findAllTopClientsByscoreAndCompetition(Integer id_Competition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addApplication(int score, Competition competition, Client client) {
		// TODO Auto-generated method stub
		Application application = new Application((float) score,competition,client);
		entityManager.persist(application);
		
	}

	@Override
	public List<Application> findApplicationById(Competition competition, Client client) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Application a where a.client=:client and a.competition=:competition",Application.class).setParameter("competition",competition).setParameter("client", client).getResultList();
	}

}
