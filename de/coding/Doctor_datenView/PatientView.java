package de.coding.Doctor_datenView;

import javafx.beans.property.SimpleStringProperty;

public class PatientView {
	SimpleStringProperty patientID;
	SimpleStringProperty name;
	SimpleStringProperty address;
	SimpleStringProperty contact;
	SimpleStringProperty disease;
	SimpleStringProperty roomType;
	SimpleStringProperty roomNumber;
	SimpleStringProperty date;
	public PatientView(String patientID, String name, String address,String contact, String disease, String roomType,String roomNumber, String date) {
		super();
		this.patientID = new SimpleStringProperty(patientID) ;
		this.name =  new SimpleStringProperty(name) ;
		this.address =  new SimpleStringProperty(address);
		this.contact =  new SimpleStringProperty(contact) ;
		this.disease =  new SimpleStringProperty(disease) ;
		this.roomType =  new SimpleStringProperty(roomType) ;
		this.roomNumber =  new SimpleStringProperty(roomNumber) ;
		this.date =  new SimpleStringProperty(date) ;
	}
	public String getPatientID() {
		return patientID.get();
	}
	public String getName() {
		return name.get();
	}
	public String getAddress() {
		return address.get();
	}
	public String getContact() {
		return contact.get();
	}
	public String getDisease() {
		return disease.get();
	}
	public String getRoomType() {
		return roomType.get();
	}
	public String getRoomNumber() {
		return roomNumber.get();
	}
	public String getDate() {
		return date.get();
	
	}
	
}
