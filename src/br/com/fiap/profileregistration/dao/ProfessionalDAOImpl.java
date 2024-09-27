package br.com.fiap.profileregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.model.ProfessionalDetail;
import br.com.fiap.profileregistration.model.ResidentDoctor;
import br.com.fiap.profileregistration.util.ConnectionBD;

public class ProfessionalDAOImpl implements ProfessionalDAO {
	
	private Connection conn = null;
	
	public ProfessionalDAOImpl() {
		ConnectionBD.getInstance();
		conn = ConnectionBD.getConnection();
		
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void includesProfessional(Professional professional) {
		String sql = "INSERT INTO PROFESSIONAL (ID, NAME, BIRTHDATE, INSTITUTION, CPF) VALUES (?, ?, ?, ?, ?)";
		
		
		//ResidentDoctor resident = new ResidentDoctor(0, null, null, null, null, null);
		/*
		 * resident.setId(10); resident.setName("Lucas");
		 * resident.setBirthDate("20/10/2000"); resident.setInstitution("Fiap");
		 * resident.setCpf("123.456.789-10");
		 */
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, professional.getId());
            stmt.setString(2, professional.getName());
            stmt.setString(3, professional.getBirthDate());
            stmt.setString(4, professional.getInstitution());
            stmt.setString(5, professional.getCpf());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit(); // Confirma a transação
                System.out.println("Profissional inserido com sucesso!");
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

}
