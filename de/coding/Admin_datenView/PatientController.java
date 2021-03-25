package de.coding.Admin_datenView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.DB_Connection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatientController implements Initializable {
	
    
    @FXML
    private TableColumn<Patient, String> patient_ID_Column;

    @FXML
    private TableColumn<Patient, String> patient_Name_Column;

    @FXML
    private TableColumn<Patient, String> PAtientAddressColumn;

    @FXML
    private TableColumn<Patient, String> PatientcontactColumn;

    @FXML
    private TableColumn<Patient, String> PatientDiseaseColumn;

    @FXML
    private TableColumn<Patient, String> doctor_ID_Column;

    @FXML
    private TableColumn<Patient, String> doctorSpecialistColumn;

    @FXML
    private TableColumn<Patient, String> roomTypeColumn;

    @FXML
    private TableColumn<Patient, String> roomNumberColumn;

    @FXML
    private TableColumn<Patient, String> dateColumn;
    
    @FXML
    private TableView<Patient> patientTableView;
    ObservableList<Patient> list;
    Model_AdminDatenView model_AdminDatenView = new Model_AdminDatenView();
    DB_Connection db_Connection ;
    
    Controller_AdminDatenView controller_AdminDatenView;
    
    void patientSearchButtonAction(ObservableList< Patient> list){
    	
   
    	
     	patient_ID_Column.setCellValueFactory(new PropertyValueFactory<>("patient_Id"));
    	patient_Name_Column.setCellValueFactory(new PropertyValueFactory<>("patient_Name"));
    	PAtientAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    	PatientcontactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    	PatientDiseaseColumn.setCellValueFactory(new PropertyValueFactory<>("disease"));
    	doctor_ID_Column.setCellValueFactory(new PropertyValueFactory<>("doctor_Id"));
    	doctorSpecialistColumn.setCellValueFactory(new PropertyValueFactory<>("specialist"));
    	roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("room_Type"));
    	roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("room_number"));
    	dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    	patientTableView.setItems(list);
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		list = Controller_AdminDatenView.patientObservableList;
		patientSearchButtonAction(list);
	
		
		
		
		// TODO Auto-generated method stub
		
		
	}

}
