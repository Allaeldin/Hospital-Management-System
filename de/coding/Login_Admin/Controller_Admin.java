package de.coding.Login_Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.DB_Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller_Admin implements Initializable {

    @FXML
    private Label dbStatus;

    @FXML
    private Circle dbStatusLight;

    @FXML
    private PasswordField passwortTextfield;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;
    private DB_Connection database = new DB_Connection();
    private Model_Admin model_Admin = new Model_Admin();
    
    

    
	@FXML
	 void loginButtonAction(ActionEvent event) { 
		
		
			String username = usernameTextField.getText();
			String passwort = passwortTextfield.getText();
			try {
				if (model_Admin.isLogin(database.getConnection(), username, passwort)) {
					try {
						loginSucce();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					System.out.println("Login fehlgeschlagen");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
	}
	
	
	
	
	public void loginSucce() throws SQLException {
		
	 	try {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("/de/coding/Admin_datenView/admin_datenViewer.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Admin Dashboard");
			stage.setResizable(false);
			stage.show();
			database.getConnection().close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	try {
		boolean dbConnection = database.open();
		
		
			if (dbConnection) {

				dbStatus.setText("Connected!");
				dbStatusLight.setFill(Color.GREEN);

			}else {


				dbStatus.setText("Disconnected!");
				dbStatusLight.setFill(Color.RED);
				
				
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
		
		
		
		
		
		
		
		
		
		
	}

}
