package br.com.fiap.profileregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.profileregistration.model.PhoneNumber;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.util.ConnectionBD;

public class PhoneNumberDAOImpl implements PhoneNumberDAO {

	
	private Connection conn = null; 
	
	public PhoneNumberDAOImpl() {
		ConnectionBD.getInstance();
		conn = ConnectionBD.getConnection();
		
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void includesPhone(Professional professional, PhoneNumber number) {
		String sql = "INSERT INTO PHONE_NUMBER (PROFESSIONALID, MAIN_PHONE) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, professional.getId());
            stmt.setString(2, number.getDigit());
            
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit(); // Confirma a transação
                System.out.println("descrição inserida!");
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
