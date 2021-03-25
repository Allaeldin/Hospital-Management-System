package de.coding.Login_Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbUtil.DB_Connection;

public class DoctorLoginModel {
	
	
	
public boolean isLogin( String id, String passwort,Connection connection,DB_Connection db_Connection) throws SQLException {
		
		db_Connection.open();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT doctorID,passwort FROM Admin_DatenView WHERE doctorID = ? and passwort = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, passwort);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
