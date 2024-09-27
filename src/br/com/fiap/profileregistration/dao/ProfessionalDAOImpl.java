package br.com.fiap.profileregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.profileregistration.model.Professional;
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
		String sql = "INSERT INTO PROFESSIONAL (ID, NAME, BIRTHDATE, INSTITUTION, CPF, TYPE, CRM) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		
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
            stmt.setString(6, professional.getType());
            stmt.setString(7, professional.getCrm());
            
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
	public static List<Professional> addCPFSList(Professional professional, ResultSet rs, List<Professional> cpfs) {
		
	
		
		professional.setCpf(professional.getCpf());
		cpfs.add(professional);
		
		return cpfs;
		
	}
	@SuppressWarnings("null")
	@Override
	public void searchIDByCPF(Professional professional, int id) {
	    String query = "SELECT ID FROM PROFESSIONAL WHERE CPF = ?";
	    ResultSet rs = null;

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, professional.getCpf()); // Definindo o valor do CPF no PreparedStatement
	        rs = stmt.executeQuery();

	        if (!rs.isBeforeFirst()) { // Verifica se o ResultSet está vazio
	            System.out.println("Não tem id para o cpf: " + professional.getCpf());
	        } else {
	            List<Professional> cpfs = new ArrayList<>();
	            while (rs.next()) {
	                professional.setId(rs.getInt("ID")); // Recuperando o ID do ResultSet
	                cpfs = ProfessionalDAOImpl.addCPFSList(professional, rs, cpfs);
	            }

	            for (Professional listProfessional : cpfs) {
	                System.out.println(listProfessional.getId() + " " + listProfessional.getCpf());
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
