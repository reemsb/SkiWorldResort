package buisinessdelegate;

import java.util.List;

import entity.SkiStation;
import serviceLocater.ServiceLocator;
import services.StationServiceRemote;

public class StationServiceDelegate {

	private static final String JNDI = "SkiWorld-ear/SkiWorld-ejb/StationService!services.StationServiceRemote";

	private static StationServiceRemote getProxy() {
		return (StationServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}

	public static void doAddStation(SkiStation station) {
		getProxy().addStation(station);                             
	}
	
	public static SkiStation doFindStationById(Integer id) {
		return getProxy().findStationById(id);
	}
	
	public static void doDeleteStationById(Integer id) {
         
		getProxy().deleteStationById(id);
	}
	
	public static void doUpdateStation(SkiStation station)
	{
		getProxy().updateStation(station);
	}
	public static List<SkiStation> doFindAllStations()
	{
		return getProxy().findAllStations();
	}
	public static List<SkiStation> doFindStationByName (String label)
	{
		return getProxy().findStationByName(label);
	}
}
