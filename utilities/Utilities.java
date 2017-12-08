package utilities;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entity.Administrator;
import entity.Client;
import entity.Competition;
import entity.SkiStation;
import services.CompetitionServiceLocal;
import services.StationServiceLocal;
import services.UserServiceLocal;

/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
@EJB
private UserServiceLocal userServiceLocal;
Client c1 = new Client();
Client c2 = new Client();
Administrator a1 = new Administrator();

@EJB
private StationServiceLocal stationServiceLocal;
SkiStation s1=new SkiStation();
@EJB
private CompetitionServiceLocal competitionServiceLocal;
Competition competition = new Competition();
Competition competition1 = new Competition();
Competition competition2 = new Competition();
Competition competition3 = new Competition();



    /**
     * Default constructor. 
     */
    public Utilities() {
        // TODO Auto-generated constructor stub
    }
    @PostConstruct
	public void initDB() {
    	c1.setNom("rim");
		c1.setPrenom("sboui");
		c1.setCIN(123);
		c1.setEmail("rim.sboui@esprit.tn");
		c1.setPassword("123");
		c1.setBirthDate(new Date());
		c1.setLevel("amateur");
		userServiceLocal.addUser(c1);
		System.out.println("*********************************");
		c2.setNom("Asma");
		c2.setPrenom("Charrada");
		c2.setCIN(123);
		c2.setEmail("asma.charrada@esprit.tn");
		c2.setPassword("123");
		c2.setBirthDate(new Date());
		c2.setLevel("amateur");
		c2.setCosts(80);
		userServiceLocal.addUser(c2);
		System.out.println("*********************************");
		s1.setLabel("wonderland");
		s1.setLatitude(11255);
		s1.setLongitude(15267);
		s1.setDescription("really awsome");
		stationServiceLocal.addStation(s1);
		System.out.println("*********************************");
        a1.setCIN(111254);
		a1.setEmail("asma.hemden@esprit.tn");
		a1.setNom("asma");
		a1.setPrenom("hemden");
		a1.setPassword("123");
		userServiceLocal.addUser(a1);
		System.out.println("*********************************");
        competition.setAdmin(a1);
        competition.setCapacity(30);
        competition.setDate(new Date());
        competition.setStation(s1);
        competition.setType("amateur");
        competition.setFinishingHour(new GregorianCalendar(2017,5,20));
        competition.setStartingHour(new GregorianCalendar(2017,5,18));
        competitionServiceLocal.addCompetition(competition);
//		System.out.println("*********************************");
//competition1.setAdmin(a1);
//competition1.setCapacity(0);
//competition1.setDate(new Date());
//competition1.setType("amateur");
//competition1.setStation(s1);
//competition1.setStartingHour(new GregorianCalendar(2017,6,1));
//competition.setFinishingHour(new GregorianCalendar(2017,6,3));
// competitionServiceLocal.addCompetition(competition1);
	System.out.println("*********************************");
	competition2.setAdmin(a1);
	competition2.setCapacity(14);
	competition2.setDate(new Date());
	competition2.setType("pro");
	competition2.setStation(s1);
	competition2.setStartingHour(new GregorianCalendar(2017,8,1));
	competition2.setFinishingHour(new GregorianCalendar(2017,8,3));
	 competitionServiceLocal.addCompetition(competition2);
	System.out.println("*********************************");
	competition3.setAdmin(a1);
	competition3.setCapacity(24);
	competition3.setDate(new Date());
	competition3.setType("pro");
	competition3.setStation(s1);
	competition3.setStartingHour(new GregorianCalendar(2017,9,1));
	competition3.setFinishingHour(new GregorianCalendar(2017,9,4));
	 competitionServiceLocal.addCompetition(competition3);

    }
}
