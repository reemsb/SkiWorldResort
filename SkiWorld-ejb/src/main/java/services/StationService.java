package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.SkiStation;

/**
 * Session Bean implementation class StationService
 */
@Stateless
@LocalBean
public  class StationService implements StationServiceRemote, StationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStation(SkiStation station) {
		// TODO Auto-generated method stub
		entityManager.persist(station);
	}

	@Override
	public SkiStation findStationById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(SkiStation.class, id);
	}

	@Override
	public void deleteStationById(Integer id) {
		// TODO Auto-generated method stub
		entityManager.remove(findStationById(id));
	}

	@Override
	public void updateStation(SkiStation station) {
		// TODO Auto-generated method stub
		entityManager.merge(station);
	}

	@Override
	public List<SkiStation> findAllStations() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from SkiStation s ").getResultList();
	}

	@Override
	public List<SkiStation> findStationByName(String label) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from SkiStation s where s.label=:label ").setParameter("label",label).getResultList();

	}

}
