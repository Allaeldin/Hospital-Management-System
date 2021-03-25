package de.coding.Doctor_datenView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppointmentSearchController implements Initializable {

    @FXML
    private TableColumn<Appointment, String> patient_IDSearchAppoinmentColumn;

    @FXML
    private TableColumn<Appointment, String> timeSearchAppointmentColumn;

    @FXML
    private TableColumn<Appointment, String> daySearchAppointmentColumn;

    @FXML
    private TableColumn<Appointment, String> dateSearchAppoinmentColumn;
    
    @FXML
    private TableView<Appointment> appoinmentTableView;
    ObservableList<Appointment> list ;
    
    
    public void showAppointment( ObservableList<Appointment> list) {
    	
    	patient_IDSearchAppoinmentColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));
    	timeSearchAppointmentColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
    	daySearchAppointmentColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
    	dateSearchAppoinmentColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    	
    	appoinmentTableView.setItems(list);
    	
    	
    }
    
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = DoctorControllerDatenView.appointmentList;	
		showAppointment(list);
	}

}
