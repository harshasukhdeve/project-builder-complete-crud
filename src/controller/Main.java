package controller;

import java.sql.SQLException;

import dao.CrudDAO;
import dao.CrudDaoInterface;
import model.User;

public class Main {

	public static void main(String args[]) throws SQLException, ClassNotFoundException {

		User user = new User();
		user.setName("Harsha");
		user.setEmail("harshasukhdeve@gmail.com");
         user.setDesignation("Jailer");
        user.setPassword("Harsha@123");
		
		CrudDaoInterface crudOperations = new CrudDAO();
		crudOperations.insert(user);
		crudOperations.getData();
		
		
	}
}