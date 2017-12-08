package tn.esprit.presentation.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entity.SkiStation;
import tn.esprit.presentation.mbean.StationBean;

@FacesConverter("sc")
public class SkiStationConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return null;
		} 
		StationBean StationBean =(StationBean) context.getApplication().evaluateExpressionGet(context, "#{StationBean}",StationBean.class);
		SkiStation station= StationBean.doFindStationByLabel(value);
		return station;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		String string = null;
		if (value instanceof SkiStation) {
			string=((SkiStation) value).getLabel();
		}
		
		return string;
	}

}
