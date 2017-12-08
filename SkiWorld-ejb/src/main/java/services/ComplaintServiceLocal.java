package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Client;
import entity.Complaint;
import entity.ComplaintID;
import entity.SkiStation;

@Local
public interface ComplaintServiceLocal {
 public void addComplaint(SkiStation Station,Client Client, String topic, String status);
 public Complaint findComplaintById(ComplaintID complaintID);
 public void deleteComplaintById(ComplaintID complaintID);
 public void updateComplaint(Complaint complaint);
 public List<Complaint> findAllComplaints();
 public List<Complaint> findAllComplaintsByClient(Client client);
public void deleteComplaint(Complaint complaintSelected);
 }
