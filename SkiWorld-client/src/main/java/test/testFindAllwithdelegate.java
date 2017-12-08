package test;

import java.util.List;

import buisinessdelegate.StationServiceDelegate;

import java.util.ArrayList;

import entity.SkiStation;

public class testFindAllwithdelegate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	List<SkiStation> stations=new ArrayList<>();
         stations=StationServiceDelegate.doFindAllStations();
		for (SkiStation s : stations) {
			System.out.println(s.getLabel());
		}
		
	}

}
