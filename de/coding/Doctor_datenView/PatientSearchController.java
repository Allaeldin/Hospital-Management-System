package de.coding.Doctor_datenView;

import java.net.URL;
import java.util.ResourceBundle;

import de.coding.Admin_datenView.Controller_AdminDatenView;
import de.coding.Admin_datenView.Patient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatientSearchController implements Initializable {

    @FXML
    private TableView<PatientView> patientTableView;

    @FXML
    private TableColumn<PatientView, String> patient_IDSearch_Column;

    @FXML
    private TableColumn<PatientView, String> patient_Name_Column;

    @FXML
    private TableColumn<PatientView, String> PatientAddressSearchColumn;

    @FXML
    private TableColumn<PatientView, String> PatientContactSearchColumn;

    @FXML
    private TableColumn<PatientView, String> PatientDiseaseSearchColumn;

    @FXML
    private TableColumn<PatientView, String> roomTypeSearchColumn;

    @FXML
    private TableColumn<PatientView, String> roomNumberSearchColumn;

    @FXML
    private TableColumn<PatientView, String> dateSearchColumn;
    ObservableList<PatientView> list;

void patientSearchButtonAction(ObservableList< PatientView> list){
    	
   
    	
	patient_IDSearch_Column.setCellValueFactory(new PropertyValueFactory<>("patientID"));
    	patient_Name_Column.setCellValueFactory(new PropertyValueFactory<>("name"));
    	PatientAddressSearchColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    	PatientContactSearchColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    	PatientDiseaseSearchColumn.setCellValueFactory(new PropertyValueFactory<>("disease"));
    	roomTypeSearchColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
    	roomNumberSearchColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
    	dateSearchColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    	patientTableView.setItems(list);
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		list = DoctorControllerDatenView.patientObservableList;
		
		patientSearchButtonAction(list);
	
		
		
		
		// TODO Auto-generated method stub
		
		
	}

}
