package de.coding.Doctor_datenView;

import java.sql.*;
import dbUtil.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbUtil.DB_Connection2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class DoctorModelDatenView {
	
	
	public static DB_Connection2 db_Connection2 = new DB_Connection2() ;
	
	
	
	public List<String > doctorDatenAusgaben(Statement statement , String id ) throws SQLException {
		
		List<String > list =  new ArrayList<String>();
		String sql = "SELECT * FROM Admin_DatenView WHERE doctorID = '"+id+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String docId = resultSet.getString(1);
			String name = resultSet.getString(2);
			String address = resultSet.getString(3);
			String email = resultSet.getString(4);
			String contact = resultSet.getString(5);
			String specialist = resultSet.getString(6);
			String salary = resultSet.getString(7);
			String passwort = resultSet.getString(8);
			
			list.add(name);
			list.add(address);
			list.add(email);
			list.add(contact);
			list.add(specialist);
			list.add(salary);
			
			
		}
		
		return list;
		
		
		
	}
	
	public boolean checkAppointment2(DB_Connection2 db_Connection2,String doc_id,String time,String day, String date) throws SQLException {
		
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT Doctor_ID, Time,Day,Date FROM Appointment WHERE Doctor_ID =? AND Time = ? AND Day = ? AND Date = ?";
		
		try {
			preparedStatement = db_Connection2.open2().prepareStatement(sql);
			preparedStatement.setString(1, doc_id);
			preparedStatement.setString(2, time);
			preparedStatement.setString(3, day);
			preparedStatement.setString(4, date);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
		db_Connection2.getConnection().close();
		}
		

	}
	
	public boolean checkPatient_ID(String docID,String patient_ID) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT Doctor_ID,Patient_ID FROM Assign_Bed  WHERE Doctor_ID = ? AND Patient_ID = ?";
		try {
			preparedStatement = db_Connection2.open2().prepareStatement(sql);
			preparedStatement.setString(1, docID);
			preparedStatement.setString(2, patient_ID);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				return true;
				
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			db_Connection2.getConnection().close();
		}
		
		
		
		
		
	}
	
	public boolean checkAppointment(Connection connection ,String patient_ID , String time, String day, String date) throws SQLException {
		

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = " SELECT Patient_ID,Time,Day,Date FROM Appointment WHERE Patient_ID=  ? AND Time = ? AND Day = ? AND Date = ?";
		try {
			
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, patient_ID);
			preparedStatement.setString(2, time);
			preparedStatement.setString(3, day);
			preparedStatement.setString(4, date);
			
			
				resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				return true;
				
			}
			
			
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}finally {
		
		
		}
		
		
	}
   public boolean insertAppointmentAtion(Statement statement,String doc_id , String patient_ID , String time, String day, String date) throws SQLException {
	
	   String sql = "INSERT INTO Appointment VALUES( '"+doc_id+ "','"+patient_ID + "','" + time + "','" + day + "','" + date +"')"; 
	   
	   try {
		  
		   db_Connection2.open2();
		   db_Connection2.getStatement().execute(sql);
		   db_Connection2.getStatement().close();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}finally {
		db_Connection2.getConnection().close();
	}
	
  }
   
   public void appointmentDelete(Statement statement, String time,String day, String date) throws SQLException {
	   
	   String sql ="DELETE FROM  Appointment WHERE Time = '"+time+"' AND Day = '"+day+"' AND Date = '"+date+"'";
	   db_Connection2.open2();
	   db_Connection2.getStatement().execute(sql);
	   db_Connection2.getStatement().close();
	   
   }
   
   public ObservableList<Appointment> loadAppointments(Statement statement, ObservableList<Appointment> list,String docID) throws SQLException {
	   
	   list = FXCollections.observableArrayList();
	   db_Connection2.open2();
	  
	
	   String sql ="SELECT Patient_ID,Time,Day ,Date FROM Appointment WHERE Doctor_ID =  '"+docID+"'";
	   ResultSet resultSet = db_Connection2.getStatement().executeQuery(sql);
	   
	   
	   while (resultSet.next()) {
		 
		   //String doc_ID = resultSet.getString("Doctor_ID");
		   String patientID = resultSet.getString("Patient_ID");
		   String time = resultSet.getString("Time");
		   String day = resultSet.getString("Day");
		   String date = resultSet.getString("Date");
		 
		   list.add(new Appointment(patientID,time,day,date));
		
	}
	   
	   resultSet.close();
	   db_Connection2.getStatement().close();
	   
	   return list;
	   
   }
   
  public ObservableList<Appointment> searchAppointment(Statement statement, ObservableList<Appointment> list,String docID,String patient_ID) throws SQLException {
	   
	   list = FXCollections.observableArrayList();
	   db_Connection2.open2();
	  
	
	   String sql ="SELECT Patient_ID,Time,Day ,Date FROM Appointment WHERE Doctor_ID =  '"+docID+"' AND Patient_ID = '"+patient_ID+"'";
	   ResultSet resultSet = db_Connection2.getStatement().executeQuery(sql);
	   
	   
	   while (resultSet.next()) {
		 
		   //String doc_ID = resultSet.getString("Doctor_ID");
		  // String patientID = resultSet.getString("Patient_ID");
		   String time = resultSet.getString("Time");
		   String day = resultSet.getString("Day");
		   String date = resultSet.getString("Date");
		 
		   list.add(new Appointment(patient_ID,time,day,date));
		
	}
	   
	   resultSet.close();
	   db_Connection2.getStatement().close();
	   
	   return list;
	   
   }
   
   
   public ObservableList<PatientView> loadAllPatient(Statement statement, ObservableList<PatientView> list,String docID) throws SQLException {
	   
	   list = FXCollections.observableArrayList();
	   db_Connection2.open2();
	  
	
	   String sql ="SELECT Patient_ID,Patient_Name,Patient_Address ,Patient_Contact,Patient_Disease,Room_Type,Room_No,Date FROM Assign_Bed WHERE Doctor_ID =  '"+docID+"'";
	   ResultSet resultSet = db_Connection2.getStatement().executeQuery(sql);
	   
	   
	   while (resultSet.next()) {
		 
		   //String doc_ID = resultSet.getString("Doctor_ID");
		   String patientID = resultSet.getString("Patient_ID");
		   String name = resultSet.getString("Patient_Name");
		   String address = resultSet.getString("Patient_Address");
		   String contact = resultSet.getString("Patient_Contact");
		   String disease = resultSet.getString("Patient_Disease");
		   String room_Type = resultSet.getString("Room_Type");
		   String room_No = resultSet.getString("Room_No");
		   String date = resultSet.getString("Date");
		 
		   list.add(new PatientView(patientID,name,address,contact,disease,room_Type,room_No,date));
		
	}
	   
	   resultSet.close();
	   db_Connection2.getStatement().close();
	   
	   return list;
	   
   }
   
   public void passwordUpdate(Statement statement,String newPassword, String oldPassword,String docID) throws SQLException {
	   db_Connection2.open2();
	   
	   String sql ="UPDATE  Admin_DatenView SET passwort = '"+newPassword+"' WHERE passwort = '"+oldPassword+"' AND doctorID = '"+docID+"'";
	   db_Connection2.getStatement().execute(sql);

	   db_Connection2.getStatement().close();
	   
	   
   }
   
   public ObservableList<PatientView> searchPatientActionView(Statement statement, ObservableList<PatientView> list ,String docID, String paiten_ID) throws SQLException {
	   
	   db_Connection2.open2();
	   list = FXCollections.observableArrayList();
	   String sql= "SELECT Patient_Name,Patient_Address ,Patient_Contact,Patient_Disease,Room_Type,Room_No,Date FROM Assign_Bed WHERE Doctor_ID = '"+docID+"' AND Patient_ID = '"+paiten_ID+"'";
	   
	   ResultSet resultSet = db_Connection2.getStatement().executeQuery(sql);
	   

	   while (resultSet.next()) {
		 
		
		   String name = resultSet.getString("Patient_Name");
		   String address = resultSet.getString("Patient_Address");
		   String contact = resultSet.getString("Patient_Contact");
		   String disease = resultSet.getString("Patient_Disease");
		   String room_Type = resultSet.getString("Room_Type");
		   String room_No = resultSet.getString("Room_No");
		   String date = resultSet.getString("Date");
		 
		   list.add(new PatientView(paiten_ID,name,address,contact,disease,room_Type,room_No,date));
		
	}
	   return list;
   }
}
