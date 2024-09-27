package br.com.fiap.profileregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	private static ConnectionBD instance;
	private static  Connection conn;
	
	// variáveis da conexão
	
	private final String URL = "jdbc:oracle:thin:@localhost:1525:xe";
	private final String USER = "System";
	private final String PASSWORD = "oracle";
	
	private ConnectionBD() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexão estabelecida");
		} catch(ClassNotFoundException e) {
			System.err.println("Driver não encontrado " + e.getMessage());
		} catch(SQLException e) {
			System.err.println("Falha na conexão" + e.getMessage());
		}
	}
	
	
	public static synchronized ConnectionBD getInstance() {
		if(instance == null) {
			instance = new ConnectionBD();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		return conn;
	}
} 
