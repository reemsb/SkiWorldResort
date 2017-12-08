package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Client;
import entity.Complaint;
import entity.ComplaintID;
import entity.SkiStation;

@Remote
public interface ComplaintServiceRemote {
	 public void addComplaint(SkiStation Station,Client Client, String topic, String status);
	 public Complaint findComplaintById(ComplaintID complaintID);
	 public void deleteComplaintById(ComplaintID complaintID);
	 public void updateComplaint(Complaint complaint);
	 public List<Complaint> findAllComplaints();
	 public List<Complaint> findAllComplaintsByClient(Client client);
}
