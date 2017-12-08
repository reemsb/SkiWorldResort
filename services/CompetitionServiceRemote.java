package services;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Competition;

@Remote
public interface CompetitionServiceRemote {
	public void addCompetition(Competition competition) ;
	public Competition findCompetitionById(Integer id);
	public void deleteCompetitionById(Integer id);
	public void updateCompetition(Competition competition);
	public List<Competition> findAllCompetitions();
	public List<Competition> findAllCompetitionsByType(String type);
    public List<Competition> findAllCompetitionsByDate(Date date);
    public List<Competition> findAllCompetitionsByDateAndType(Date date,String type);
    public void sustractCapacity(Competition competition);
    public void addCapacity(Competition competition);
	public List<Competition> findCompetitionByMonth();
}
