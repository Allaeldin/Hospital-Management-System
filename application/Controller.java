package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable {

	  @FXML
	    private Button admin;

    @FXML
    private ImageView doctor;
    
    
    @FXML
    private Button doctorLoginButton;
    
    @FXML
    void doctorLoginAction(ActionEvent event) {
    	
    	
    	try {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("/de/coding/Login_Doctor/login_Doctor.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Admin");
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    
    

    @FXML
    void adminLogin(ActionEvent event) {
    	try {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			Pane root = (Pane) fxmlLoader.load(getClass().getResource("/de/coding/Login_Admin/admin.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Admin");
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }
    
  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}

}
