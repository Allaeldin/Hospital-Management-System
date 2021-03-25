package de.coding.Admin_datenView;

import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RoomController implements Initializable {

	@FXML
	private Label room_1;

	@FXML
	private Label room_2;

	@FXML
	private Label room_3;

	@FXML
	private Label room_4;

	@FXML
	private Label room_5;

	@FXML
	private Label room_6;

	@FXML
	private Button doneButton;

	@FXML
	private Button CancelButtonRoom;

	static Model_AdminDatenView model_AdminDatenViewRoomController;
	static DB_Connection db_Connection1;;
	String roomStauts_1;
	String roomStauts_2;
	String roomStauts_3;
	String roomStauts_4;

	String roomStauts_5;
	String roomStauts_6;
	boolean check_Room1 = true;
	boolean check_Room2 = true;

	boolean check_Room3 = true;
	boolean check_Room4 = true;
	boolean check_Room5 = true;
	boolean check_Room6 = true;


	@FXML
	void doneActionButton(ActionEvent event) {
		
		Stage stage = (Stage)doneButton.getScene().getWindow();
		stage.close();

	}

	@FXML
	void showRoom(ActionEvent event) {

		try {
			check_Room1 = model_AdminDatenViewRoomController.chickRoom(db_Connection1.getStatement(), room_1.getText());
			

			if (!check_Room1) {
				room_1.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_1.getText();
				roomStauts_1 = "Full";
			} else if (check_Room1) {

				room_1.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				roomStauts_1 = "Empty";
			}
			// ********************************

			check_Room2 = model_AdminDatenViewRoomController.chickRoom(db_Connection1.getStatement(), room_2.getText());
		

			if (!check_Room2) {
				room_2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_2.getText();

			} else if (check_Room2) {

				room_2.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

			}

			// ********************************

			check_Room3 = model_AdminDatenViewRoomController.chickRoom(db_Connection1.getStatement(), room_3.getText());
			System.out.println(check_Room3);

			if (!check_Room3) {
				room_3.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_3.getText();

			} else if (check_Room3) {

				room_3.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

			}
			
			//********************************
			
			check_Room4 = model_AdminDatenViewRoomController.chickRoom( db_Connection1.getStatement(),room_4.getText());
			System.out.println(check_Room4);
			

			if ( !check_Room4) {
				room_4.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_4.getText();
				
			}else if ( check_Room4 ) {
				
			
				
				room_4.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				
			}
			
			//********************************
			
			check_Room5 = model_AdminDatenViewRoomController.chickRoom( db_Connection1.getStatement(),room_5.getText());
			System.out.println(check_Room5);
			

			if ( !check_Room5) {
				room_5.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_5.getText();
				
			}else if ( check_Room5 ) {
				
			
				
				room_5.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				
			}
			
			//********************************
			
			check_Room6 = model_AdminDatenViewRoomController.chickRoom( db_Connection1.getStatement(),room_6.getText());
			System.out.println(check_Room6);
			

			if ( !check_Room6) {
				room_6.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				model_AdminDatenViewRoomController.roomNumber = room_6.getText();
				
			}else if ( check_Room6 ) {
				
			
				
				room_6.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;

	}
	
	 boolean roomStauts = true;
	 
	  @FXML
	    void room(MouseEvent event) {

	    
		 
		 room_1.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					try {

						if (event.getClickCount() == 1 && (check_Room1) && roomStauts) {
							room_1.setBackground(
									new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
							model_AdminDatenViewRoomController.roomNumber = room_1.getText();
							roomStauts = false;
						
						} else if (event.getClickCount() == 2 && (check_Room1)) {

							room_1.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
							roomStauts = true;
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			});

			// ***********************
		 
		 room_2.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					  

					if (event.getClickCount() == 1 && (check_Room2) && roomStauts) {
						room_2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						model_AdminDatenViewRoomController.roomNumber = room_2.getText();
						roomStauts= false;
					} else if (event.getClickCount() == 2 && (check_Room1)) {

						room_2.setBackground(
								new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
						roomStauts = false;

					}

				}
			});

			// ***********************
		 
		 room_3.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					if (event.getClickCount() == 1 && (check_Room3) && roomStauts) {
						room_3.setBackground(
								new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						model_AdminDatenViewRoomController.roomNumber = room_3.getText();
						roomStauts = false;
					} else if (event.getClickCount() == 2 && (check_Room3)) {

						room_3.setBackground(
								new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

						roomStauts = true;
					}

				}
			});

			// ***********************
		 
			room_4.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					if (event.getClickCount() == 1 && (check_Room4)) {
						room_4.setBackground(
								new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						model_AdminDatenViewRoomController.roomNumber = room_4.getText();

						roomStauts = false;
					} else if (event.getClickCount() == 2 && (check_Room4)) {

						room_4.setBackground(
								new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
						roomStauts = true;
					}

				}
			});

			// ***********************
		 
	 }
	 
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

//		room_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//
//				try {
//
//					if (event.getClickCount() == 1 && (check_Room1) && roomStauts) {
//						room_1.setBackground(
//								new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//						model_AdminDatenViewRoomController.roomNumber = room_1.getText();
//						roomStauts = false;
//					
//					} else if (event.getClickCount() == 2 && (check_Room1)) {
//
//						room_1.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//						roomStauts = true;
//					}
//
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//			}
//		});

		// ***********************
//		room_2.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				  
//
//				if (event.getClickCount() == 1 && (check_Room2) && roomStauts) {
//					room_2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//					model_AdminDatenViewRoomController.roomNumber = room_2.getText();
//					roomStauts= false;
//				} else if (event.getClickCount() == 2 && (check_Room1)) {
//
//					room_2.setBackground(
//							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//					roomStauts = false;
//
//				}
//
//			}
//		});
//
//		// ***********************
//		room_3.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//
//				if (event.getClickCount() == 1 && (check_Room3) && roomStauts) {
//					room_3.setBackground(
//							new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//					model_AdminDatenViewRoomController.roomNumber = room_3.getText();
//					roomStauts = false;
//				} else if (event.getClickCount() == 2 && (check_Room3)) {
//
//					room_3.setBackground(
//							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//
//					roomStauts = true;
//				}
//
//			}
//		});
//
//		// ***********************
//		room_4.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//
//				if (event.getClickCount() == 1 && (check_Room4)) {
//					room_4.setBackground(
//							new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//					model_AdminDatenViewRoomController.roomNumber = room_4.getText();
//
//					roomStauts = false;
//				} else if (event.getClickCount() == 2 && (check_Room4)) {
//
//					room_4.setBackground(
//							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//					roomStauts = true;
//				}
//
//			}
//		});
//
//		// ***********************
		room_5.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (event.getClickCount() == 1 && (check_Room5) && roomStauts) {
					room_5.setBackground(
							new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
					model_AdminDatenViewRoomController.roomNumber = room_5.getText();

					roomStauts = false;
				} else if (event.getClickCount() == 2 && (check_Room5)) {

					room_5.setBackground(
							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
					roomStauts = true;
				}

			}
		});

		// ***********************
		room_6.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (event.getClickCount() == 1 && (check_Room6) && roomStauts) {
					room_6.setBackground(
							new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
					model_AdminDatenViewRoomController.roomNumber = room_6.getText();
					roomStauts = false;
				} else if (event.getClickCount() == 2 && (check_Room6)) {

					room_6.setBackground(
							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

					roomStauts = true;
				}

			}
		});

	}

}