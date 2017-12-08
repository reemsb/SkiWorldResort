package test;

import buisinessdelegate.StationServiceDelegate;
import entity.SkiStation;

public class UpdateStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkiStation station=new SkiStation();
				station=StationServiceDelegate.doFindStationById(2);
		station.setDescription("change is made");
        StationServiceDelegate.doUpdateStation(station); 
		
	}

}
