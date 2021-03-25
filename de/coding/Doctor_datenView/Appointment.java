package de.coding.Doctor_datenView;

import javafx.beans.property.SimpleStringProperty;

public class Appointment {
	
	SimpleStringProperty patientID;
	SimpleStringProperty time ;
	SimpleStringProperty day;
	SimpleStringProperty date;
	public Appointment(String patientID, String time, String day,String date) {
		super();
		this.patientID = new SimpleStringProperty(patientID) ;
		this.time = new SimpleStringProperty(time) ;
		this.day = new SimpleStringProperty(day) ;
		this.date = new SimpleStringProperty(date)  ;
	}
	public String getPatientID() {
		return patientID.get();
	}
	public String getTime() {
		return time.get();
	}
	public String getDay() {
		return day.get();
	}
	public String getDate() {
		return date.get();
	}
	
	
	
	
	
	
	
	
	
	

}
