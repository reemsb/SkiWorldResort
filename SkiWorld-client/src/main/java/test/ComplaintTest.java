package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import buisinessdelegate.StationServiceDelegate;
import buisinessdelegate.UserServiceDelegate;
import entity.Client;
import entity.Complaint;
import entity.ComplaintID;
import entity.SkiStation;
import javassist.expr.NewArray;
import services.ComplaintServiceLocal;
import services.ComplaintServiceRemote;
import services.StationServiceRemote;
import services.UserServiceRemote;

public class ComplaintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		

		
			Context context;
			try {
				context = new InitialContext();
				ComplaintServiceRemote proxy = (ComplaintServiceRemote) context.lookup("/SkiWorld-ear/SkiWorld-ejb/ComplaintService!services.ComplaintServiceRemote");
				Client client=(Client) UserServiceDelegate.dofindClientById(1);
				System.out.println(client.getNom());
				List<Complaint> complaints=new ArrayList<>();
				complaints =proxy.findAllComplaintsByClient(client);
				for (Complaint complaint : complaints) {
					System.out.println(complaint.getStatus());
				}} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("not working");
			}
           
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date("2016/11/16 12:08:43");
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		//SkiStation station=StationServiceDelegate.doFindStationById(1);
			//ComplaintID complaintID=new ComplaintID(1,1,date);
			//Client client= proxy.findClientById(1);
			//System.out.println("client"+client.getEmail());
			//System.out.println("station"+station.getDescription());
			//proxy.addComplaint(station,client,"hello","can u");

		//	client.setId(5);
			//client.setNom("aa");
		//	client.setEmail("iusfd@sdf.f");
			//client.setPrenom("dfgz");
		//	client.setPassword("rim");
		//	client.setCIN(56485484);
			// complaint =new Complaint();
			//proxy.deleteComplaintById(complaintID);
			//proxy.findComplaintById(1,1,date);
		//	proxy.findComplaintById(complaintID);
			//Complaint comp =proxy.findComplaintById(complaintID);
		//	System.out.println(comp.getTopic());
			    //findbyclient
			//System.out.println(proxy.findAllComplaints());
			//proxy.updateComplaint(complaint);
			
			//second part test
			
	}}	
				
		
 
		
	


