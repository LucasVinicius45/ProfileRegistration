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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void includesProfessional(Professional professional) {
        String sql = "INSERT INTO PROFESSIONAL (NAME, BIRTHDATE, INSTITUTION, CPF, TYPE, CRM) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"ID"})) { // O "new String[]{"ID"}" faz referência ao campo de chave primária
            stmt.setString(1, professional.getName());
            stmt.setString(2, professional.getBirthDate());
            stmt.setString(3, professional.getInstitution());
            stmt.setString(4, professional.getCpf());
            stmt.setString(5, professional.getType());
            stmt.setString(6, professional.getCrm());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    professional.setId(generatedKeys.getInt(1));
                }
                conn.commit();
                System.out.println("Profissional inserido com sucesso! ID: " + professional.getId());
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


    
    public Boolean searchIDByCPF(String cpf) {
        String query = "SELECT ID FROM PROFESSIONAL WHERE CPF = ?";
        Boolean existUser = false;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                    System.out.println("ID encontrado para o CPF " + cpf + ": " + rs.getInt("ID"));
                    existUser = true;
                } else {
                    System.out.println("Nenhum ID encontrado para o CPF: " + cpf);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existUser;
    }

    public static List<Professional> addCPFSList(Professional professional, ResultSet rs, List<Professional> cpfs) {
        professional.setCpf(professional.getCpf());
        cpfs.add(professional);
        return cpfs;
    }

	
}
