package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import buisinessdelegate.CompetitionServiceDelegate;
import buisinessdelegate.StationServiceDelegate;
import entity.Competition;
import entity.SkiStation;

public class CompetitionAdapter extends AbstractTableModel{
	String[] headers={"id","Type","Date","Starting Hour","Finishing Hour","Capacity"};
    List<Competition> competitions = new ArrayList<>();
    public CompetitionAdapter() {
    	 
    	competitions = CompetitionServiceDelegate.doFindAllCompetitions();
    
        
	} 

@Override
public int getColumnCount() {
	  return headers.length;
}

@Override
public int getRowCount() {
	 return competitions.size();
}
 @Override
public String getColumnName(int i ){
    return headers[i];
}
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	 switch (columnIndex) {
   
    case 0:
        return competitions.get(rowIndex).getId();
    case 1:
        return competitions.get(rowIndex).getType();
    case 2:
        return competitions.get(rowIndex).getDate();
    case 3:
    	 return competitions.get(rowIndex).getStartingHour();
    case 4:
         return competitions.get(rowIndex).getFinishingHour();
    case 5:
        return competitions.get(rowIndex).getCapacity();
    default:
        return null;
	 }}


}
