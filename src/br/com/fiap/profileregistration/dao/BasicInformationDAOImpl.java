package br.com.fiap.profileregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.util.ConnectionBD;

public class BasicInformationDAOImpl implements BasicInformationDAO {

	private Connection conn = null; 
	
	public BasicInformationDAOImpl() {
		ConnectionBD.getInstance();
		conn = ConnectionBD.getConnection();
		
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void includesInformation(Professional professional, BasicInformation information) {
		String sql = "INSERT INTO BASIC_INFORMATION (PROFESSIONALID, DESCRIPTION) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, professional.getId());
            stmt.setString(2, information.getDescription());
            
            
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
