package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Client;
import entity.Competition;
import entity.Complaint;
import entity.ComplaintID;
import entity.SkiStation;

/**
 * Session Bean implementation class ComplaintService
 */
@Stateless
@LocalBean
public  class ComplaintService implements ComplaintServiceRemote, ComplaintServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ComplaintService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addComplaint(SkiStation Station,Client Client, String topic, String status ) {
		// TODO Auto-generated method stub
		Complaint complaint=new Complaint(topic,status,Station,Client);
		entityManager.persist(complaint);
	}

	

	@Override
	public void updateComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		entityManager.merge(complaint);
	}

	@Override
	public List<Complaint> findAllComplaints() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select c from Complaint c ").getResultList();
	}

	@Override
	public List<Complaint> findAllComplaintsByClient(Client client) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select c from Complaint c where c.client=:client").setParameter("client",client).getResultList();
	}

	@Override
	public Complaint findComplaintById(ComplaintID complaintID) {
		// TODO Auto-generated method stub
		return (Complaint) entityManager.find(Complaint.class,complaintID);
	}

	@Override
	public void deleteComplaintById(ComplaintID complaintID) {
		entityManager.remove(findComplaintById(complaintID));
		
	}

	@Override
	public void deleteComplaint(Complaint complaintSelected) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(complaintSelected));
	}

	
	

}
