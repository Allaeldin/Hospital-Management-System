package de.coding.Admin_datenView;

import java.io.IOException;

import de.coding.Admin_datenView.*;
import de.coding.PopUpWindow.PopupWindow;
import de.coding.Doctor_datenView.*;

import java.net.URL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dbUtil.DB_Connection;
import dbUtil.DB_Connection2;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller_AdminDatenView implements Initializable {

	@FXML
	private TextField doctorIDTextfield;

	@FXML
	private TextField doctorName;

	@FXML
	private TextField address;

	@FXML
	private TextField email;

	@FXML
	private TextField contact;

	@FXML
	private TextField specialist;

	@FXML
	private TextField salary;
	


	@FXML
	private Button searchButton;
	@FXML
	private Button editButton;

	@FXML
	private TextField passwort;

	@FXML
	private TextField nameTextfiled;

	@FXML
	private TextField addressTextfield;

	@FXML
	private TextField emailTextfield;

	@FXML
	private TextField contactTextfield;

	@FXML
	private TextField specialistTextfield;

	@FXML
	private TextField salarytextfield;

	@FXML
	private TextField idSearchTextField;
	
	@FXML
	private Button cancelButton;

	@FXML
	private TableView<Doctor> doctorTableView;

	@FXML
	private TableColumn<Doctor, String> idColumn;

	@FXML
	private TableColumn<Doctor, String> nameColumn;

	@FXML
	private TableColumn<Doctor, String> addressColumn;

	@FXML
	private TableColumn<Doctor, String> emailColumn;

	@FXML
	private TableColumn<Doctor, String> contactColumn;

	@FXML
	private TableColumn<Doctor, String> specialistColumn;

	@FXML
	private TableColumn<Doctor, String> salaryColumn;
	
	
    @FXML
    private TextField patientID;

    @FXML
    private TextField patientName;

    @FXML
    private TextField patientAddress;

    @FXML
    private TextField patientContact;

    @FXML
    private TextField patientDisease;

    @FXML
    private Button addPatientButton;

  
    
    
    
    
    //*****************************+

    @FXML
    private ChoiceBox<String> choiceBoxDoctorID;

    @FXML
    private Label doctorSpecialistAssignBedTLabel;

    @FXML
    private ChoiceBox<String> ChoiceBoxRoomType;

    @FXML
    private DatePicker date;

    @FXML
    private TextField patientNameAssignTextfield;

    @FXML
    private TextField patientAddressAssignTextfield;

    @FXML
    private TextField patientContactAssignTextfield;

    @FXML
    private TextField patientDiseaseAssignTextfield;

    @FXML
    private TextField searchAssignTextfield;

    @FXML
    private Button searchAssignButton;
    @FXML
    private Button assignBedButton;
    @FXML
    private Button cancelAssignBedButton;
    @FXML
    private TextField doctorSpecialistAssignBed;

    
    @FXML
     TextField patientSearchID_Textfield;

    @FXML
    private Button patientSearchButton;
   //********************************
    
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
    
   //********************************
    @FXML
    private TextField docDeleteTextfiled;

    @FXML
    private Button docDeleteButton;
    //******************************
	
	
	List<String> list;
	ObservableList<Patient> patientsList;
	static ObservableList<Patient> patientObservableList;
	
	ObservableList<Doctor>doctorList;
	ObservableList<String> doctorIDList = FXCollections.observableArrayList();

	Model_AdminDatenView model_AdminDatenView = new Model_AdminDatenView();
	PopupWindow popupWindow = new PopupWindow();
	
	RoomController roomController = new RoomController();

	
	
	private DB_Connection dbConnection  = new DB_Connection();;
	private DB_Connection2 dbConnection2 = new DB_Connection2();
	// private Controller_Update controller_Update = new Controller_Update();
	  
	
	//*************************************

	@FXML
	void submitButtonAction(ActionEvent event) throws SQLException {
		String doctorID = doctorIDTextfield.getText();
		String doctorNam = doctorName.getText();
		String addres = address.getText();
		String email_ = email.getText();
		String contact_ = contact.getText();
		String specialist_ = specialist.getText();
		String salary_ = salary.getText();
		String passwort_ = passwort.getText();
		boolean isAddedDaten = model_AdminDatenView.addDoctor(dbConnection.getStatement(), doctorID, doctorNam, addres,
				email_, contact_, specialist_, salary_, passwort_);

		
		
		if (isAddedDaten) {
			

			System.out.println("Doctor added successfully");

		} else {
			System.out.println("Doctor can not be added");
		}
		
		clearAllFielder();

	}
	
	@FXML
    void docDeleteActionButton(ActionEvent event) throws SQLException {
		model_AdminDatenView.docDeleteActionButton(dbConnection.getStatement(), docDeleteTextfiled.getText());
       popupWindow.display("Doctor sccessfully deleted ");
    }
	

	@FXML
	void searchbuttonAction(ActionEvent event) {


	suche();
		

	}

	
	public void suche() {
		

		try {
			list = model_AdminDatenView.updateShowWindow(dbConnection.getStatement(), idSearchTextField.getText());

			nameTextfiled.setText(list.get(1));
			addressTextfield.setText(list.get(2));
			emailTextfield.setText(list.get(3));
			contactTextfield.setText(list.get(4));
			specialistTextfield.setText(list.get(5));
			salarytextfield.setText(list.get(6));
			String id = idSearchTextField.getText();
			doctorList = model_AdminDatenView.loadDoctorDetials(dbConnection.getStatement(), doctorList,id);
			idColumn.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
			emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
			contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
			specialistColumn.setCellValueFactory(new PropertyValueFactory<>("specialist"));
			salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
			
			doctorTableView.setItems(doctorList);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

    @FXML
    void docEditAction(ActionEvent event) throws SQLException {
        model_AdminDatenView.docId = list.get(0);
    	model_AdminDatenView.docName = list.get(1);
    	model_AdminDatenView.docAddress= list.get(2);
    	model_AdminDatenView.docEmail= list.get(3);
    	model_AdminDatenView.docConact = list.get(4);
    	model_AdminDatenView.docSpecialist= list.get(5);
    	model_AdminDatenView.docSalary = list.get(6);
    	
    	model_AdminDatenView.doctorEdit(dbConnection.getStatement(),idSearchTextField.getText(), nameTextfiled.getText(), addressTextfield.getText(), emailTextfield.getText(), contactTextfield.getText(), specialistTextfield.getText(), salarytextfield.getText());

    	suche();
    	popupWindow.display("Information sccessfully added");
    	clearAllFielder();
    	
    }
    
    
    
    @FXML
    void cancelAssignBedActionButton(ActionEvent event) {
    	//clearAllFielder();
    }
    
    public void clearAllFielder() {
    	nameTextfiled.clear();
    	addressTextfield.clear();
    	emailTextfield.clear();
    	contactTextfield.clear();
    	specialistTextfield.clear();
    	salarytextfield.clear();
    	idSearchTextField.clear();
    	patientID.clear();
    	patientName.clear();
    	patientAddress.clear();
    	patientContact.clear();
    	patientDisease.clear();
    	
    	
    	
    	 doctorIDTextfield.clear();;

    	
    	 doctorName.clear();;

    	
    	 address.clear();;

    	 email.clear();;

    	 contact.clear();;
         specialist.clear();;

          salary.clear();
          passwort.clear();
    	
          patientNameAssignTextfield.clear();
          patientAddressAssignTextfield.clear();
          patientContactAssignTextfield.clear();
          patientDiseaseAssignTextfield.clear();
          patientID.clear();
          searchAssignTextfield.clear();
          doctorSpecialistAssignBed.clear();
        
    	
    	
    }
    
    
    
    @FXML
    void addPatientAction(ActionEvent event) throws SQLException {
    	
    	model_AdminDatenView.addPatient(dbConnection.getStatement(), patientID.getText(), patientName.getText(), patientAddress.getText(), patientContact.getText(), patientDisease.getText());
    	popupWindow.display("Information sccessfully added");
    	clearAllFielder();
    }

	
    List<String> list2;

    @FXML
    void searchButtonAssignBed(ActionEvent event) throws SQLException {
    	list2 = model_AdminDatenView.searchButtonAssignBed(dbConnection.getStatement(), searchAssignTextfield.getText());
    	    
    	
    	      patientNameAssignTextfield.setText(list2.get(1));;

    	    
    	     patientAddressAssignTextfield.setText(list2.get(2));;

    	     patientContactAssignTextfield.setText(list2.get(3));;

    	     patientDiseaseAssignTextfield.setText(list2.get(4));;

    }
    
    String doctor_IDChioceBox;
    String doctorSpecialistChioceBox;
    String datePicker ;
    String roomTypeChioceBox;
    
    
    @FXML
    void assignBedActionButton(ActionEvent event) throws IOException {
    	String patient_ID = list2.get(0);
    	String patient_Name = list2.get(1);
    	String patient_Address = list2.get(2);
    	String patient_Contact = list2.get(3);
    	String pateint_Disease = list2.get(4);
    	
    	
    	
    	
    	try {
			model_AdminDatenView.assignBed(dbConnection.getStatement(), patient_ID, patient_Name, patient_Address, patient_Contact, pateint_Disease, doctor_IDChioceBox, doctorSpecialistChioceBox, roomTypeChioceBox, datePicker);
			popupWindow.display("Information sccessfully added");
			clearAllFielder();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    
  

    @FXML
     void showDate(ActionEvent event) {
    	 
    	
    	LocalDate ld = date.getValue();
    	
    	datePicker = ld.toString();
    	
    	
    	
    }
    
    
    @FXML
    void choiceBoxDoctorIDAction(MouseEvent event) {
    	
    	

    }
    
    
    
    
    @FXML
    void loadAllPatient(ActionEvent event) throws SQLException {
    	
    	patientsList = model_AdminDatenView.loadAllPatient(dbConnection.getStatement(), patientsList);
    	
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
    	patientTableView.setItems(patientsList);
    	
    	
    	

    }
   static  String  id;
    
    @FXML
    void patientSearchButtonAction(ActionEvent event) throws SQLException {
         id = patientSearchID_Textfield.getText();
    	
    	patientObservableList = model_AdminDatenView.patientSearchButtonAction(dbConnection.getStatement(), patientObservableList, id);
    	
    	Stage stage = new Stage();
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	try {
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("patientSearch.fxml").openStream());
			Scene scene = new Scene(root, 1250, 400);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }    
    


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	
		
	    try {
			dbConnection.open();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
		List<String>list1;
		 
  
		
   	RoomController.model_AdminDatenViewRoomController = model_AdminDatenView;
   	RoomController.db_Connection1 = dbConnection;
   	 
   	 
   	 try {
		list1=model_AdminDatenView.doctorIdAuflisten(dbConnection.getStatement());
		for (String id : list1) {
			doctorIDList.add(id);
			
			
		}
		
		choiceBoxDoctorID.setItems(doctorIDList);
		
		choiceBoxDoctorID.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			
				
				String docID = (String)choiceBoxDoctorID.getItems().get((int)newValue);
				doctor_IDChioceBox = docID;
				;
				String spString =	model_AdminDatenView.specialistInfo(dbConnection.getStatement(), docID);
				doctorSpecialistChioceBox = spString;
				doctorSpecialistAssignBed.setText(spString);
				
			}
		});
		
		
		
		ObservableList<String> roomTypeList = FXCollections.observableArrayList("General", "VIP","ICU");
		
		
		ChoiceBoxRoomType.setItems(roomTypeList);
		
		
    	
		

		
		
		ChoiceBoxRoomType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				String roomType = (String) ChoiceBoxRoomType.getItems().get((int)newValue); 
				roomTypeChioceBox = roomType;
				
				if (roomType.equals("General")) {
					
					
					Stage stage = new Stage();
			    	
			    	FXMLLoader fxmlLoader = new FXMLLoader();
			    	Pane root;
					try {
						root = (Pane) fxmlLoader.load(getClass().getResource("roomType.fxml").openStream());
						Scene scene = new Scene(root, 800, 400);
						stage.setScene(scene);
						stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	 
		
	}

}
