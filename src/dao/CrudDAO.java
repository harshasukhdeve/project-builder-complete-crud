package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;

public class CrudDAO implements CrudDaoInterface{

//	private Connection connection = ConnectionManager.getConnection();
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	//create
	public void create() throws SQLException, ClassNotFoundException {
		 Connection connection = ConnectionManager.getConnection();
	  String sql = "CREATE TABLE DATA(NAME VARCHAR(100) NOT NULL,EMAIL VARCHAR(100) PRIMARY KEY,DESIGNATION VARCHAR(60) NOT NULL,PASSWORD VARCHAR(40) NOT NULL)";
	   if(connection!=null) {
		   statement = connection.createStatement();
		   int status = statement.executeUpdate(sql);
		   System.out.println(status);  
	   }
	   else
		   System.out.println("not connected");
	   connection.close();
	}

	//insert
    public void insert(User user) throws SQLException, ClassNotFoundException {
    	Connection connection = ConnectionManager.getConnection();
	  if(connection!=null) {
		  preparedStatement = connection.prepareStatement("INSERT INTO DATA VALUES(?,?,?,?)");
		  preparedStatement.setString(1,user.getName());
		  preparedStatement.setString(2,user.getEmail());
		  preparedStatement.setString(3,user.getDesignation());
		  preparedStatement.setString(4,user.getPassword()); 
		  preparedStatement.executeUpdate();
	  }
	  else
		  System.out.println("not connected");
    		
	}
    	
    //update
	public void update(User user) throws SQLException, ClassNotFoundException  {
		Connection connection = ConnectionManager.getConnection();
		String sql = "UPDATE DATA SET NAME = "+user.getName()+"WHERE EMAIL = "+user.getEmail();
		if(connection!=null) {
			   statement = connection.createStatement();
			   statement.executeUpdate(sql);
			   System.out.println("updated");  
		   }
		   else
			   System.out.println("not connected");
		   connection.close();
	}

	//delete
	public void delete(User user) throws SQLException, ClassNotFoundException  {	
		Connection connection = ConnectionManager.getConnection();
		String sql = "DELETE FROM DATA WHERE EMAIL = "+user.getEmail();
		if(connection!=null) {
			   statement = connection.createStatement();
			   statement.executeUpdate(sql);
			   System.out.println("deleted");  
		   }
		   else
			   System.out.println("not connected");
		   connection.close();
	}

	
	//SELECT fetch details 
	public void getData() throws SQLException, ClassNotFoundException {		
		Connection connection = ConnectionManager.getConnection();
	  String sql = "SELECT * FROM DATA";
	  if(connection!=null) {
		  statement = connection.createStatement();
		  ResultSet rs = statement.executeQuery(sql);
		  while(rs.next()) {
			  System.out.println(rs.getString("email")+" "+rs.getString("password"));
		  }
		  
		  
	  }else
		  System.out.println("not connected");
	}


	
	

}