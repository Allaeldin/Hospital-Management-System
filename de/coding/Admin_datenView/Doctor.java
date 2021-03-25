package de.coding.Admin_datenView;

import javafx.beans.property.SimpleStringProperty;

public class Doctor {
	
	
	private SimpleStringProperty doctorID;
	private SimpleStringProperty name;
	private SimpleStringProperty address;
	private SimpleStringProperty email;
	private SimpleStringProperty contact;
	private SimpleStringProperty specialist;
	private SimpleStringProperty  salary;
	public Doctor(String doctorID, String name, String address,String email, String contact, String specialist,String salary) {
		super();
		this.doctorID = new SimpleStringProperty(doctorID);
		this.name = new SimpleStringProperty(name);
		this.address = new SimpleStringProperty(address);
		this.email = new SimpleStringProperty(email);
		this.contact = new SimpleStringProperty(contact);
		this.specialist = new SimpleStringProperty(specialist);
		this.salary = new SimpleStringProperty(salary);
	}
	public String getDoctorID() {
		return doctorID.get();
	}
	public String getName() {
		return name.get();
	}
	public String getAddress() {
		return address.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getContact() {
		return contact.get();
	}
	public String getSpecialist() {
		return specialist.get();
	}
	public String getSalary() {
		return salary.get();
		
		
	}
	public void setDoctorID(SimpleStringProperty doctorID) {
		this.doctorID = doctorID;
	}
	public void setName(SimpleStringProperty name) {
		this.name = name;
	}
	public void setAddress(SimpleStringProperty address) {
		this.address = address;
	}
	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}
	public void setContact(SimpleStringProperty contact) {
		this.contact = contact;
	}
	public void setSpecialist(SimpleStringProperty specialist) {
		this.specialist = specialist;
	}
	public void setSalary(SimpleStringProperty salary) {
		this.salary = salary;
	}
	
	

}
