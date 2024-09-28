package br.com.fiap.profileregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.profileregistration.model.Address;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.util.ConnectionBD;

public class AddressDAOImpl implements AddressDAO {
	
	private Connection conn = null;
	
	public AddressDAOImpl() {
		// TODO Auto-generated constructor stub
		ConnectionBD.getInstance();
		conn = ConnectionBD.getConnection();
		
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void includesAdress(Professional professional, Address adress){
		String sql = "INSERT INTO ADDRESS (PROFESSIONALID, POSTALCODE, STREET, CITY, STATE, COUNTRY) VALUES (?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        	stmt.setInt(1, professional.getId());
	            stmt.setString(2, adress.getPostalCode());
	            stmt.setString(3, adress.getStreet());
	            stmt.setString(4, adress.getCity());
	            stmt.setString(5, adress.getState());
	            stmt.setString(6, adress.getCountry());
	            
	            
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                conn.commit(); // Confirma a transação
	                System.out.println("endereço inserido!");
	            } else {
	                System.out.println("Nenhuma linha inserida.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	                conn.rollback(); // Desfaz a transação em caso de erro
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        }
		}


	@Override
	public void searchIDByCPF(Professional professional, int id) {
		// TODO Auto-generated method stub

	}

}
