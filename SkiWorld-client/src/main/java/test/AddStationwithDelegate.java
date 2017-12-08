package test;

import buisinessdelegate.StationServiceDelegate;
import entity.SkiStation;

public class AddStationwithDelegate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkiStation station = new SkiStation();
		//station.setId(2);
		station.setLabel("what");
		station.setLatitude(45);
		station.setLongitude(30);
		station.setDescription("this station is really really recommented for xgames players");
        
		StationServiceDelegate.doAddStation(station);

	}

}
