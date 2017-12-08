package services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import entity.Competition;

/**
 * Session Bean implementation class CompetitionService
 */
@Stateless
@LocalBean
public class CompetitionService implements CompetitionServiceRemote, CompetitionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CompetitionService() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public void addCompetition(Competition competition) {
		// TODO Auto-generated method stub
		entityManager.persist(competition);
	}

	@Override
	public Competition findCompetitionById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Competition.class,id);
	 //entityManager.createNativeQuery("db.ORDER.findOne({\"_id\":\""+id +"\"})", Competition.class).getSingleResult();
	}

	@Override
	public void deleteCompetitionById(Integer id) {
		// TODO Auto-generated method stub
	 entityManager.remove(findCompetitionById(id));
	}

	@Override
	public void updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		entityManager.merge(competition);
	}

	@Override
	public List<Competition> findAllCompetitions() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select c from Competition c ").getResultList();
	}

	@Override
	public List<Competition> findAllCompetitionsByType(String type) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select c from Competition c where c.type=:type").setParameter("type",type).getResultList();

	}

	@Override
	public List<Competition> findAllCompetitionsByDate(Date date) {
		// TODO Auto-generated method stub
		
		return entityManager.createQuery("select c from Competition c where c.date=:date").setParameter("datee",date).getResultList();

	}

	@Override
	public List<Competition> findAllCompetitionsByDateAndType(Date date, String type) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select c from Competition c where c.date=:date and c.type=:date").setParameter("date", date).setParameter("type", type).getResultList();	

	}

	@Override
	public void sustractCapacity(Competition competition) {
		// TODO Auto-generated method stub
		entityManager.createQuery("Update c from Competition c where c.capacity=c.capacity-1");

	}

	@Override
	public void addCapacity(Competition competition) {
		// TODO Auto-generated method stub
		entityManager.createQuery("Update c from Competition c where c.capacity=c.capacity+1");

	}

	@Override
	public List<Competition> findCompetitionByMonth() {
		// TODO Auto-generated method stub
//		List<Date> MM =new ArrayList<>();
			//List<Competition> Competitions
			//for (Date m:months)
			//{
		//	}
		//	return entityManager.createQuery("select c from Competition c where s.date=:monthdate").setParameter("monthdate", monthdate).getResultList();	

		return null;
	}

}
