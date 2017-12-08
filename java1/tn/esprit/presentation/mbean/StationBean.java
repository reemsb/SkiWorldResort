package tn.esprit.presentation.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.SkiStation;
import services.StationServiceLocal;

@ManagedBean
@ViewScoped
public class StationBean {
	private List<SkiStation> stations=new ArrayList<>();
	@EJB
	private StationServiceLocal stationServiceLocal;
	private SkiStation station = new SkiStation();

	public SkiStation doFindStationByLabel(String Label)
	{ 
		return (SkiStation) stationServiceLocal.findStationByName(Label);
	}

	public List<SkiStation> getStations() {
		stations=stationServiceLocal.findAllStations();
		return stations;
	}

	public void setStations(List<SkiStation> stations) {
		this.stations = stations;
	}
	 
}
