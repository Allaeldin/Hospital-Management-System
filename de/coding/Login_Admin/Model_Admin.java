package de.coding.Login_Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model_Admin {
	
	public boolean isLogin(Connection connection,String username,String passwort) throws SQLException  {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM Admin_Login WHERE username = ? AND passwort = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, passwort);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return true;
				
			}
			return false;
		  } catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
	
		
		
		
		
		
	}

}
