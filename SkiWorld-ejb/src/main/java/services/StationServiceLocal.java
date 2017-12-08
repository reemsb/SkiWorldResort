package services;



import java.util.List;

import javax.ejb.Local;

import entity.SkiStation;

@Local
public interface StationServiceLocal {
	
	void addStation (SkiStation station);
	public SkiStation findStationById(Integer id) ;
	public void deleteStationById(Integer id);
	public void updateStation(SkiStation station);
	public List<SkiStation> findAllStations();
	public List<SkiStation> findStationByName(String label);

}
