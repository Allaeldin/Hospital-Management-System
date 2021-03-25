package de.coding.Admin_datenView;

import javafx.beans.property.SimpleStringProperty;

public class Patient {
	
	SimpleStringProperty patient_Id;
	SimpleStringProperty patient_Name;
	SimpleStringProperty     address;
	SimpleStringProperty      contact;
	SimpleStringProperty     disease;
	SimpleStringProperty doctor_Id;
	SimpleStringProperty specialist;
	SimpleStringProperty room_Type;
	SimpleStringProperty room_number;
	SimpleStringProperty date;
	
	public Patient(String patient_Id, String patient_Name, String address,String contact,String disease,String doctor_Id, String specialist, String room_Type,String room_number,String date ) {
		
		this.patient_Id = new SimpleStringProperty(patient_Id);
		this.patient_Name = new SimpleStringProperty(patient_Name);
		this.address = new SimpleStringProperty(address);
		this.contact = new SimpleStringProperty(contact);
		this.disease = new SimpleStringProperty(disease);
		this.doctor_Id = new SimpleStringProperty(doctor_Id);
		this.specialist = new SimpleStringProperty(specialist);
		this.room_Type = new SimpleStringProperty(room_Type);
		this.room_number = new SimpleStringProperty(room_number);
		this.date = new SimpleStringProperty(date);
	}

	public String getPatient_Id() {
		return patient_Id.get();
	}

	public String getPatient_Name() {
		return patient_Name.get();
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

	public String getDoctor_Id() {
		return doctor_Id.get();
	}

	public String getSpecialist() {
		return specialist.get();
	}

	public String getRoom_Type() {
		return room_Type.get();
	}

	public String getRoom_number() {
		return room_number.get();
	}

	public String getDate() {
		return date.get();
	}

	
	

}
