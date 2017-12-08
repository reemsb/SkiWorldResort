package test;

import buisinessdelegate.StationServiceDelegate;
import entity.SkiStation;

public class TestAffStationWithDelegate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         SkiStation station=new SkiStation();
       //  station=StationServiceDelegate.doFindStationByName("France finest");
         System.out.println(station.getLabel());
	}

}
