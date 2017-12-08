package gui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import buisinessdelegate.StationServiceDelegate;
import entity.SkiStation;
public class StationAdapter extends AbstractTableModel{
	
		 String[] headers={"nbr station","Label","lattitude","longitude","Description"};
		    List<SkiStation> stations = new ArrayList<>();
		    public StationAdapter() {
		    	 
		    	stations = StationServiceDelegate.doFindAllStations();
		    
		        
			} 
		
		@Override
		public int getColumnCount() {
			  return headers.length;
		}

		@Override
		public int getRowCount() {
			 return stations.size();
		}
		 @Override
	    public String getColumnName(int i ){
	        return headers[i];
	    }
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			 switch (columnIndex) {
	       
	        case 0:
	            return stations.get(rowIndex).getId();
	        case 1:
	            return stations.get(rowIndex).getLabel();
	        case 2:
	            return stations.get(rowIndex).getLatitude();
	        case 3:
	        	 return stations.get(rowIndex).getLongitude();
	        case 4:
	             return stations.get(rowIndex).getDescription();
	         
	        default:
	            return null;
			 }}
		}
			 
			 
		
