package de.coding.Doctor_datenView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import dbUtil.DB_Connection;
import dbUtil.DB_Connection2;
import de.coding.Login_Doctor.DoctorLoginController;
import de.coding.PopUpWindow.PopupWindow;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DoctorControllerDatenView implements Initializable {

	@FXML
	private Label doctorNameLabel;

	@FXML
	private Label doctorAddressLabel;

	@FXML
	private Label doctorEmailLabel;

	@FXML
	private Label doctorContactLabel;

	@FXML
	private Label DoctorSpecialistLabel;

	// *****************************

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

	@FXML
	private Label label4;

	@FXML
	private Label label5;

	@FXML
	private Label label6;

	@FXML
	private Label label7;

	@FXML
	private Label label8;

	@FXML
	private Label label11;

	@FXML
	private Label label16;

	@FXML
	private Label label21;

	@FXML
	private Label label12;

	@FXML
	private Label label17;

	@FXML
	private Label label22;

	@FXML
	private Label label13;

	@FXML
	private Label label18;

	@FXML
	private Label label23;

	@FXML
	private Label label19;

	@FXML
	private Label label20;

	@FXML
	private Label label9;

	@FXML
	private Label label14;

	@FXML
	private Label label24;

	@FXML
	private Label label25;

	@FXML
	private Label label10;

	@FXML
	private Label label15;

	// ****************************+
	@FXML
	private TextField patient_IDTextfield;

	@FXML
	private DatePicker datePicker;
	String date;

	@FXML
	void showDate(ActionEvent event) {
		LocalDate ld = datePicker.getValue();
		date = ld.toString();
	}
	// *****************************
	
	
	
	@FXML
    private TextField patient_IDTextfield_Appointment;

    

    @FXML
    private TableColumn<Appointment, String> patient_ID_Appointment_Column;

    @FXML
    private TableColumn<Appointment, String> time_Appointment_Column;

    @FXML
    private TableColumn<Appointment, String> day_Appointment_Column;

    @FXML
    private TableColumn<Appointment, String> date_Appointment_Column;

    @FXML
    private TextField patient_id_AppointmentTextfield;

    @FXML
    private Button search_AppointmentButton;

    @FXML
    private Button load_AppointmentButton;
    @FXML
    private TableView<Appointment> appoitmentTableView;
    ObservableList<Appointment>  appointmentsList;
	//******************************

	@FXML
	private Label doctorSalaryLabel;
	DoctorModelDatenView doctorModelDatenView = new DoctorModelDatenView();
	List<String> list;
	boolean check1, check2, check3, check4, check5, check6, check7, check8, check9, check10, check11, check12, check13,
			check14, check15, check16, check17, check18, check19, check20, check21, check22, check23, check24, check25;

	String patient_ID;
	public static DB_Connection db_Connection2;
	DB_Connection2 db_Connection1 = new DB_Connection2();
	// *****************************

    @FXML
    private TextField patientIDViewTextfield;

    @FXML
    private TableColumn<PatientView, String> patientView_IDColumn;

    @FXML
    private TableColumn<PatientView, String> patientNameViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientAddressViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientContactViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientDiseaseViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientRoomTypViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientRoomNumberViewColumn;

    @FXML
    private TableColumn<PatientView, String> patientDateViewColumn;
    
    @FXML
    private TableView<PatientView> patientViewTableView;
    ObservableList<PatientView> patientsList;
	//******************************
    @FXML
    private Label username;

    @FXML
    private TextField oldPasswordTextfield;

    @FXML
    private TextField newPasswordTextfield;

    @FXML
    private Button updateButton;
    //*****************************
	
    @FXML
    void updateActionButton(ActionEvent event) throws SQLException {
    	String oldPassword = oldPasswordTextfield.getText();
    	String newPassword =  newPasswordTextfield.getText();
 
    	doctorModelDatenView.passwordUpdate(db_Connection2.getStatement(), newPassword, oldPassword,DoctorLoginController.docId);
    	popupWindow.display("Successfully updated!");
    	
    }
    
    
	@FXML
    void loadActionButton(ActionEvent event) throws SQLException {
		
		appointmentsList = doctorModelDatenView.loadAppointments(db_Connection2.getStatement(), appointmentsList,DoctorLoginController.docId);
		
		patient_ID_Appointment_Column.setCellValueFactory(new PropertyValueFactory<>("patientID"));
		time_Appointment_Column.setCellValueFactory(new PropertyValueFactory<>("time"));
		day_Appointment_Column.setCellValueFactory(new PropertyValueFactory<>("day"));
		date_Appointment_Column.setCellValueFactory(new PropertyValueFactory<>("date"));
		System.out.println("Test");
		
		appoitmentTableView.setItems(appointmentsList);

    }

	


    @FXML
    void loadPatientViewAction(ActionEvent event) throws SQLException {
    	patientsList = doctorModelDatenView.loadAllPatient(db_Connection2.getStatement(), patientsList, DoctorLoginController.docId );
    	
    	patientView_IDColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));
    	patientNameViewColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    	patientAddressViewColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    	patientContactViewColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    	patientDiseaseViewColumn.setCellValueFactory(new PropertyValueFactory<>("disease"));
    	patientRoomTypViewColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
    	patientRoomNumberViewColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
    	patientDateViewColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    	
    	
    	
    	
    	patientViewTableView.setItems(patientsList);

    }

    String patientId ;
    static ObservableList<PatientView > patientObservableList;
    
    @FXML
    void searchPatientActionView(ActionEvent event) throws SQLException {

    	patientId = patientIDViewTextfield.getText();
    	
    	patientObservableList  =	doctorModelDatenView.searchPatientActionView(db_Connection2.getStatement(), patientObservableList, DoctorLoginController.docId, patientId);
    	
    	Stage stage = new Stage();
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	try {
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("docPatientSearch.fxml").openStream());
			Scene scene = new Scene(root, 1250, 400);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    static ObservableList<Appointment > appointmentList;
    
    @FXML
    void searchAppointment(ActionEvent event) throws SQLException {
    	
    	String id = patient_IDTextfield_Appointment.getText();
    	
    	appointmentList = doctorModelDatenView.searchAppointment(db_Connection2.getStatement(), appointmentList, DoctorLoginController.docId, id);
    	

    	Stage stage = new Stage();
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	try {
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("docAppointmentSearch.fxml").openStream());
			Scene scene = new Scene(root, 549, 470);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
	
	

	@FXML
	void showAppoitments(ActionEvent event) throws SQLException {

		patient_ID = patient_IDTextfield.getText();
		db_Connection2.open();
		check1 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "7:00", "Monday",
				date);
		if (check1) {
			label1.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		// ************************************
		check2 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "7:00", "Tuesday",
				date);
		if (check2) {
			label2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		// ************************************
		check3 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "7:00",
				"Wendnesday", date);
		if (check3) {
			label3.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label3.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		// ************************************
		check4 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "7:00", "Thursday",
				date);
		if (check4) {
			label2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label4.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		// ************************************
		check5 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "7:00", "Friday",
				date);
		if (check5) {
			label2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label5.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

		// ************************************
		check6 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "8:00", "Monday",
				date);
		if (check6) {
			label6.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label6.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check7 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "8:00", "Tuesday",
				date);
		if (check7) {
			label7.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label7.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check8 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "8:00",
				"Wendnesday", date);
		if (check8) {
			label8.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label8.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check9 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "8:00", "Thursday",
				date);
		if (check9) {
			label9.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label9.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check10 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "8:00", "Friday",
				date);
		if (check10) {
			label10.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label10.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check11 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "9:00", "Monday",
				date);
		if (check11) {
			label11.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label11.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check12 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "9:00", "Tuesday",
				date);
		if (check12) {
			label12.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label12.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check13 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "9:00",
				"Wendnesday", date);
		if (check13) {
			label13.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label13.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check14 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "9:00",
				"Thursday", date);
		if (check14) {
			label14.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label14.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check15 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "9:00", "Friday",
				date);
		if (check15) {
			label15.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label15.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check16 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "10:00", "Monday",
				date);
		if (check16) {
			label16.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label16.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check17 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "10:00",
				"Tuesday", date);
		if (check17) {
			label17.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label17.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check18 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "10:00",
				"Wendnesday", date);
		if (check18) {
			label18.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label18.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check19 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "10:00",
				"Thursday", date);
		if (check19) {
			label19.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label19.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check20 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "10:00", "Friday",
				date);
		if (check20) {
			label20.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label20.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check21 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "11:00", "Monday",
				date);
		if (check21) {
			label21.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label21.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check22 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "11:00",
				"Tuesday", date);
		if (check22) {
			label22.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label22.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check23 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "11:00",
				"Wendnesday", date);
		if (check23) {
			label23.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label23.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check24 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, "11:00",
				"Thursday", date);
		if (check24) {
			label24.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label24.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		// ************************************
		check25 = doctorModelDatenView.checkAppointment2(db_Connection1, DoctorLoginController.docId, ":00", "Friday",
				date);
		if (check25) {
			label25.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

		} else {
			label25.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}

	}

	PopupWindow popupWindow = new PopupWindow();
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			String doc_ID = DoctorLoginController.docId;
			patient_ID = patient_IDTextfield.getText();
			username.setText(doc_ID);
			db_Connection2.open();
			list = doctorModelDatenView.doctorDatenAusgaben(db_Connection2.getStatement(), doc_ID);
			doctorNameLabel.setText(list.get(0));
			doctorAddressLabel.setText(list.get(1));
			doctorEmailLabel.setText(list.get(2));
			doctorContactLabel.setText(list.get(3));
			DoctorSpecialistLabel.setText(list.get(4));
			doctorSalaryLabel.setText(list.get(5));
			
			



			label1.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					try {
						patient_ID = patient_IDTextfield.getText();

						if (true) {

							System.out.println(DoctorLoginController.docId);
							// System.out.println(patient_ID);

							if (event.getClickCount() == 2 && (!check1) &&  doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label1.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "7:00", "Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label1.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "7:00",
											"Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						} 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			});

			// ************************************
			label2.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check2)&&  doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label2.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "7:00", "Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label2.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "7:00",
											"Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			// ************************************
			label3.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check3)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label3.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "7:00", "Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label3.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "7:00",
											"Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			// ************************************
			label4.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {
							if (event.getClickCount() == 2 && (!check4) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {

								label4.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "7:00", "Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label4.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "7:00",
											"Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label5.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {

							if (event.getClickCount() == 2 && (!check5)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {								label5.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "7:00", "Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label5.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "7:00",
											"Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			// ************************************
			label6.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check6) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label6.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "8:00", "Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label6.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "8:00",
											"Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label7.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check7) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label7.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "8:00", "Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label7.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "8:00",
											"Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label8.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check8) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label8.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "8:00", "Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label8.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "8:00",
											"Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label9.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {

							if (event.getClickCount() == 2 && (!check9) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label9.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "8:00", "Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label9.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "8:00",
											"Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			// ************************************
			label10.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {
							if (event.getClickCount() == 2 && (!check10) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {

								label10.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "8:00", "Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label10.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "8:00",
											"Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label11.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {

							if (event.getClickCount() == 2 && (!check11) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label11.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "9:00", "Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label11.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "9:00",
											"Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label12.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check12)&&doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label12.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "9:00", "Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label12.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "9:00",
											"Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			// ************************************
			label13.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check13) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label13.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "9:00", "Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label13.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "9:00",
											"Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label14.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check14)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label14.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "9:00", "Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label14.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "9:00",
											"Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label15.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check15) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label15.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "9:00", "Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label15.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "9:00",
											"Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label16.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check16)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label16.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "10:00", "Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label16.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "10:00",
											"Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label17.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check17) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label17.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "10:00", "Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label17.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "10:00",
											"Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label18.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check18)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label18.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "10:00", "Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label18.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "10:00",
											"Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label19.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check19) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label19.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "10:00", "Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label19.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "10:00",
											"Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label20.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check20)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label20.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "10:00", "Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label20.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "10:00",
											"Friday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label21.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check21)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label21.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "11:00", "Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label21.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "11:00",
											"Monday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label22.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check22)&& doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label22.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "11:00", "Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label22.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "11:00",
											"Tuesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label23.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check23)&&doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label23.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "11:00", "Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label23.setBackground(new Background(
										new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "11:00",
											"Wendnesday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label24.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					patient_ID = patient_IDTextfield.getText();

					try {
						if (true) {

							if (event.getClickCount() == 2 && (!check24) && doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
								label24.setBackground(
										new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
											patient_ID, "11:00", "Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (event.getClickCount() == 1) {
								label24.setBackground(
										new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
								try {
									doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "11:00",
											"Thursday", date);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}else {
								popupWindow.display("The Patient is not exist");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			// ************************************
			label25.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					
					patient_ID = patient_IDTextfield.getText();
					
					try {
						if (true) {


						if (event.getClickCount() == 2 && (!check25)&&doctorModelDatenView.checkPatient_ID(DoctorLoginController.docId, patient_ID)) {
							label25.setBackground(
									new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
							try {
								doctorModelDatenView.insertAppointmentAtion(db_Connection2.getStatement(), doc_ID,
										patient_ID, "11:00", "Friday", date);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else if (event.getClickCount() == 1) {
							label25.setBackground(
									new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
							try {
								doctorModelDatenView.appointmentDelete(db_Connection2.getStatement(), "11:00", "Friday",
										date);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}else {
							popupWindow.display("The Patient is not exist");
						}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			db_Connection2.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
