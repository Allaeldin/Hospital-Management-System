package de.coding.Admin_datenView;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model_AdminDatenView {
	private final String TABLE_Admin_DatenView = "Admin_DatenView";
	private final String QUERY_DATA_TABLE_DatenView = "SELECT * FROM "+ TABLE_Admin_DatenView;
	Model_AdminDatenView model ;
	private List<String> list = new ArrayList<>();
	String docId;
	String docName;
	String docAddress;
	String docEmail;
	String docConact;
	String docSpecialist;
	String docSalary;
	String roomNumber;
	String roomStatus;
	


	public static String doctorID;
	
	public Model_AdminDatenView() {
		
		
	}
	
	public void chickroomType() {
		System.out.println(roomNumber);
	}
	
	public Model_AdminDatenView(String id) {
		this.doctorID = id;
	}
	
	
	public boolean addDoctor(Statement statement,String doctorID,String doctorName,String address,String email,String contact,String specialist,String salary,String passwort) {
		

		
		try {
			

			if (statement==null) {
				return false;
			}
			String sql = "INSERT INTO Admin_DatenView VALUES " + "('" +doctorID + "','" + doctorName + "','" + address + "','" + email + "','"+contact+"','"+specialist+"','"+salary +"','"+passwort+"')";
			statement.execute(sql);
			statement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	public void docDeleteActionButton(Statement statement,String docID) throws SQLException{
		
		statement.execute("DELETE FROM Admin_DatenView WHERE doctorID = '"+docID+"'");
		
		
	}
	
	public List<String>  updateShowWindow(Statement statement,String doctorID) {
		
		String sql ="SELECT * FROM "+TABLE_Admin_DatenView+" WHERE doctorID= '"+doctorID+"'";
		
		try {
		
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				
				String doctorId = resultSet.getString(1);
			String doctorName = resultSet.getString(2);
			String address= resultSet.getString(3);
			String email = resultSet.getString(4);
			String contact = resultSet.getString(5);
			String specialist = resultSet.getString(6);
			String salary = resultSet.getString(7);
			String passwort = resultSet.getString(8);
			
			
			
			
			System.out.println(doctorName);
			System.out.println(address);
			
			list.add(0, doctorId);
			
			list.add(1, doctorName);
			list.add(2, address);
			list.add(3, email);
			list.add(4, contact);
			list.add(5, specialist);
			list.add(6, salary);
			list.add(7, passwort);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
		
	}
	
	
	
	
	
public ObservableList<Doctor> loadDoctorDetials(Statement statement , ObservableList<Doctor> list, String id)throws SQLException{
		
		list = FXCollections.observableArrayList();
		String sql = "SELECT * FROM "+TABLE_Admin_DatenView+" WHERE doctorID= '"+id+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String doctorID = resultSet.getString(1);
			String name = resultSet.getString(2);
			String  address = resultSet.getString(3);
			String email = resultSet.getString(4);
			String contact = resultSet.getString(5);
			String specialist = resultSet.getString(6);
			String salary = resultSet.getString(7);
			String passwort = resultSet.getString(8);
			list.add(new Doctor(doctorID, name, address, email, contact, specialist, salary));
			
		}
		statement.close();
		return list;
		
	}
	
	
	
	
	public void doctorEdit(Statement statement,String id ,String doctorName,String address,String email,String contact,String specialist,String salary) throws SQLException {
		
		String sql1 = "UPDATE "+TABLE_Admin_DatenView+" SET doctorName = '"+doctorName+"'  WHERE doctorID ='"+id+"'";
		String sql2 = "UPDATE "+TABLE_Admin_DatenView+" SET address = '"+address+"'  WHERE doctorID ='"+id+"'";
		String sql3 = "UPDATE "+TABLE_Admin_DatenView+" SET Email = '"+email+"'  WHERE doctorID ='"+id+"'";
		String sql4 = "UPDATE "+TABLE_Admin_DatenView+" SET Contact = '"+contact+"'  WHERE doctorID ='"+id+"'";
		String sql5 = "UPDATE "+TABLE_Admin_DatenView+" SET specialist = '"+specialist+"'  WHERE doctorID ='"+id+"'";
		String sql6 = "UPDATE "+TABLE_Admin_DatenView+" SET salary = '"+salary+"'  WHERE doctorID ='"+id+"'";
		
		statement.execute(sql1);
		
		statement.execute(sql2);
		
		
		statement.execute(sql3);
		
		
		statement.execute(sql4);
		
		
		statement.execute(sql5);
		
		statement.execute(sql6);
		
		
		
		
	}
	
	
	public boolean addPatient(Statement statement,String patientID,String patientName,String patientAddress,String patientContact,String patientDisease) {
		
		String sql = "INSERT INTO Patient VALUES " + "('" +patientID + "','" + patientName + "','" + patientAddress + "','" + patientContact + "','"+patientDisease+"')";
		try {
			statement.execute(sql);
			statement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
	
	
	public List<String> searchButtonAssignBed(Statement statement, String id) throws SQLException {
		
		
		List<String> list = new ArrayList<>();
		
		String sql = "SELECT * FROM Patient WHERE Patient_ID = '"+id+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String patientID = resultSet.getString(1);
			String name = resultSet.getString(2);
			String address = resultSet.getString(3);
			String contact = resultSet.getString(4);
			String disease = resultSet.getString(5);
			list.add(id);
			list.add(name);
			list.add(address);
			list.add(contact);
			list.add(disease);
			
		}
		
		return list;
		
	}
	
	
	public List<String> doctorIdAuflisten(Statement statement) throws SQLException {
		
		List<String>idLite= new ArrayList<>();
		String sql =" SELECT * FROM Admin_DatenView";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String idString = resultSet.getString(1);
			idLite.add(idString);
			
		}
		return idLite;
		
	}
	
	 
	public String specialistInfo(Statement statement, String id) {
		String specialist="";
		String sql =" SELECT * FROM Admin_DatenView WHERE doctorID = '"+id+"'";
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				 specialist = resultSet.getString("Specialist");
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  specialist;
	}
	
	public boolean chickRoom(Statement statement,String roomNo) throws SQLException {
		List<String> roomList= new ArrayList<>();
		String sql = "SELECT * FROM Assign_Bed   ";
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String room = resultSet.getString("Room_No");
			roomList.add(room);
		
			
			
		}
		
		int count=1;
		
		for (String room : roomList) {
			if (room.equals(roomNo)) {
				count++;
			}
		}
		if (roomList.contains(roomNo) && count>6) {
			
			return false;
		}else {
			
			return true;
		}
		
		
	}
	
	public void assignBed(Statement statement,String patient_ID,String patient_Name,String patient_Address, String patient_Contact, String pateint_Disease, String doctor_ID,String specialist,String roomType,String date) throws SQLException {
		
		String sql = "INSERT INTO Assign_Bed VALUES " + "('" +patient_ID + "','" + patient_Name + "','" + patient_Address + "','" + patient_Contact + "','"+pateint_Disease+"','"+doctor_ID+"','"+specialist+"','"+roomType+"','"+roomNumber+"','"+date+"')";
		
		statement.execute(sql);
		statement.close();
		
		
		
	}
	
	
	public ObservableList<Patient> loadAllPatient(Statement statement,ObservableList<Patient> list) throws SQLException {
		
		String sql ="SELECT * FROM Assign_Bed ";
		ResultSet resultSet = statement.executeQuery(sql);
		list = FXCollections.observableArrayList();
		
		while (resultSet.next()) {
			String patient_id = resultSet.getString(1);
			String patient_Name = resultSet.getString(2);
			String address = resultSet.getString(3);
			String contact = resultSet.getString(4);
			String disease = resultSet.getString(5);
			String doctor_id=resultSet.getString(6);
			String specialist = resultSet.getString(7);
			String roomType = resultSet.getString(8);
			String roomNumber = resultSet.getString(9);
			String date = resultSet.getString(10);
			list.add(new Patient(patient_id, patient_Name, address, contact, disease, doctor_id, specialist, roomType, roomNumber, date));
			
		}
		return list ;
		
		
	}
	
	public ObservableList<Patient>  patientSearchButtonAction(Statement statement, ObservableList<Patient> list ,String id) throws SQLException {
		
		String sql = "SELECT * FROM Assign_Bed WHERE Patient_ID = '"+id+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		list = FXCollections.observableArrayList();
		while (resultSet.next()) {
			String patient_id = resultSet.getString(1);
			String patient_Name = resultSet.getString(2);
			String address = resultSet.getString(3);
			String contact = resultSet.getString(4);
			String disease = resultSet.getString(5);
			String doctor_id=resultSet.getString(6);
			String specialist = resultSet.getString(7);
			String roomType = resultSet.getString(8);
			String roomNumber = resultSet.getString(9);
			String date = resultSet.getString(10);
			list.add(new Patient(patient_id, patient_Name, address, contact, disease, doctor_id, specialist, roomType, roomNumber, date));
			
			
			
		}
		return list;
		
	}
	
}
