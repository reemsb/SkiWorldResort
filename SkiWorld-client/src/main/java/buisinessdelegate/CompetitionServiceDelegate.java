package buisinessdelegate;

import java.sql.Date;
import java.util.List;

import entity.Competition;
import serviceLocater.ServiceLocator;
import services.CompetitionServiceRemote;

public class CompetitionServiceDelegate {
	private static final String JNDI = "SkiWorld-ear/SkiWorld-ejb/CompetitionService!services.CompetitionServiceRemote";

	private static CompetitionServiceRemote getProxy() {
		return (CompetitionServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}

	public static void doAddCompetition(Competition competition) {
		getProxy().addCompetition(competition);                             
	}
	
	public static void doaddCompetition(Competition competition)
	{
		getProxy().addCapacity(competition);
	}
	public static Competition doFindCompetitionById(Integer id)
	{
		return getProxy().findCompetitionById(id);
	}
	public static void doDeleteCompetitionById(Integer id)
	{
		getProxy().deleteCompetitionById(id);
	}
	public static void doUpdateCompetition(Competition competition)
	{
		getProxy().updateCompetition(competition);
	}
	public static List<Competition> doFindAllCompetitions()
	{
		return getProxy().findAllCompetitions();
	}
	public static List<Competition> doFindAllCompetitionsByType(String type)
	{
		return getProxy().findAllCompetitionsByType(type);
	}
    public static List<Competition> doFindAllCompetitionsByDate(Date date)
    {
    	return getProxy().findAllCompetitionsByDate(date);
    }
    public static List<Competition> DoFindAllCompetitionsByDateAndType(Date date, String type)
    {
    	return getProxy().findAllCompetitionsByDateAndType(date, type);
    }
    public static void doSustractCapacity(Competition competition)
    {
    	 getProxy().sustractCapacity(competition);
    }
    public static void doAddCapacity(Competition competition)
    {
    	getProxy().addCapacity(competition);
    }
    
    
	}
