package de.coding.Login_Doctor;

import java.io.IOException;
import de.coding.Doctor_datenView.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.DB_Connection;
import de.coding.PopUpWindow.PopupWindow;
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

;public class DoctorLoginController implements Initializable {

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
    
    DoctorLoginModel doctorLoginModel = new DoctorLoginModel();
    DB_Connection db_Connection = new DB_Connection();
    PopupWindow popupWindow = new PopupWindow();
    public static String docId;

    @FXML
    void loginButtonAction(ActionEvent event) throws SQLException {
    	boolean check = doctorLoginModel.isLogin(usernameTextField.getText(), passwortTextfield.getText(), db_Connection.getConnection(),db_Connection );
    	if (check) {
    		docId = usernameTextField.getText();
    		
    		Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			Pane root;
			try {
				root = (Pane) fxmlLoader.load(getClass().getResource("/de/coding/Doctor_datenView/doctor_DatenView.fxml").openStream());
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Admin");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	}else {
    		 popupWindow.display("Fehlgeschlagen!!!");
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			
			
		boolean db =	db_Connection.open();
		DoctorControllerDatenView.db_Connection2 = db_Connection;
		//DoctorModelDatenView.db_Connection = db_Connection;
			
			if (db) {
				dbStatus.setText("Connected");
				dbStatusLight.setFill(Color.GREEN);
			}else {
				dbStatus.setText("Disconnected");
				dbStatusLight.setFill(Color.RED);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
