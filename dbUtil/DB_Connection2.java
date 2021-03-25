package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection2 {

	public static final String DB_NAME = "Hospital System.db";
	public static final String PATH = "/Users/hallo/eclipse-workspace/Hospital_Mangement_System/src/";
	public static final String CONNECTION_STRING = "jdbc:sqlite:"+PATH+DB_NAME;
	private Connection connection;
	private Statement statement;
	
	
	public Connection open2()throws SQLException {
		try {
			connection = DriverManager.getConnection(CONNECTION_STRING);
			this.statement = connection.createStatement();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}	
		return connection;
		
		
	}


	public Connection getConnection() {
		return connection;
	}


	public Statement getStatement() {
		return this.statement;
	}



	
	
	
	

}
