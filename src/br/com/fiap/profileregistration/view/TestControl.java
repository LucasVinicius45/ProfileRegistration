package br.com.fiap.profileregistration.view;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.profileregistration.dao.ProfessionalDAOImpl;
import br.com.fiap.profileregistration.model.Adress;
import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Email;
import br.com.fiap.profileregistration.model.Experience;
import br.com.fiap.profileregistration.model.InputController;
import br.com.fiap.profileregistration.model.Mentor;
import br.com.fiap.profileregistration.model.PhoneNumber;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.model.ProfessionalDetail;
import br.com.fiap.profileregistration.model.ResidentDoctor;
import br.com.fiap.profileregistration.util.ConnectionBD;

public class TestControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputController input = new InputController();
	
		Professional professional = TestControl.showUser(input);
		
		/*
		professional.getDetail().setEmail(TestControl.showEmail(input));
		professional.getDetail().setBasicInformation(TestControl.showBasicInformation(input));
		professional.getDetail().setPhoneNumber(TestControl.showPhoneNumber(input));
		professional.getDetail().setAdress(TestControl.showAdress(input));
		// resident.getDetail().setTask(TestControl.showTask());
		professional.getDetail().setExperience(TestControl.showExperience(input));
		professional.show();
		System.out.println("\n --- REGISTRO GERAL --- ");
		professional.getDetail().show();
		input.closeScanner();
		*/
		
		// ConnectionBD connectionBD = ConnectionBD.getInstance();
       // Connection conn = connectionBD.getConnection();

            ProfessionalDAOImpl professionalDAO = new ProfessionalDAOImpl();
            professionalDAO.includesProfessional(professional); 

            // Feche a conexão ao final
         
    }
	
	/**
	 * Apresenta o usuário, perguntando suas informções básicas
	 * @param input
	 * @return
	 */
	public static Email showEmail(InputController input) {
		System.out.println("\n--- EMAIL ---");
		Email email = new Email();
		email.register(input);
		return email;
	}
	
	/**
	 * mostra o numero de celular
	 * @param input
	 * @return
	 */
	public static PhoneNumber showPhoneNumber(InputController input) {
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.register(input);
		return phoneNumber;
	}
	
	/**
	 * Apresenta o usuário de acordo com seu tipo
	 * @param input
	 * @param type
	 * @return
	 */
	public static Professional showUser(InputController input) {
		
		double choiceNumber = 0;
		
		do {
			choiceNumber = input.getDouble("Escolha: \n1 - Médico Residente \n2 - Mentor");
		} while(choiceNumber != 1 && choiceNumber != 2);
		
		ProfessionalDetail detail = new ProfessionalDetail();
		String name = input.getString("Digite seu nome: ");
		String cpf = detail.registerCPF(input);
		String dateBirth = input.getDate("Data de Nascimento: dd/MM/yyyy ");
		String institution = input.getString("Digite sua instituição de ensino: ");
		String crm = input.getString("Digite seu crm: ");
		// Professional user = new Professional(name, cpf);
		
		int id = (int) (Math.random() * 5000);
		if( choiceNumber == 1) {
			ResidentDoctor resident = new ResidentDoctor(id, name, cpf, dateBirth, institution, crm);
			
			resident.setDetail(detail);
			resident.show();
			System.out.println("Você escolheu residente");
			return resident;
		} else {
			System.out.println("Você escolheu mentor");
			Mentor mentor = new Mentor(name, cpf, dateBirth, institution, crm);
			mentor.setDetail(detail);
			mentor.show();
			return mentor;
		}	
		
	}
	
	/**
	 * Apresenta uma descrição opcional
	 * @param input
	 * @return
	 */
	
	public static BasicInformation showBasicInformation(InputController input) {
		System.out.println("\n--- INFORMAÇÕES BÁSICAS --- ");
		BasicInformation information = new BasicInformation();
		information.register(input);
		return information;
	}
	
	/**
	 * Apresenta a opção de cadastrar o endereço da pessoa
	 * @param input
	 * @return
	 */
	public static Adress showAdress(InputController input) {
		System.out.println("\n--- ENDEREÇO --- ");
		String country = input.getString("Informe seu País: ");
		String state = input.getString("Informe seu estado: ");
		String city = input.getString("Informe sua cidade: ");
		String postalCode = input.getString("Informe seu CEP: ");
		String street = input.getString("Informe sua Rua e complemento: ");
		
		
		Adress adress = new Adress(street, city, state, postalCode, country);
		adress.show();
		return adress;
	}

	/**
	 * Registra a experiência da pessoa
	 * @param input
	 * @return
	 */
	public static Experience showExperience(InputController input) {
		System.out.println("\n--- EXPERIÊNCIAS ---");
		String profession = input.getString("Informe sua profissão: ");
		String description = input.getString("Informe uma breve descrição: ");
		String startDate = input.getString("Informe a data de ínicio de sua carreira: ");
		String endDate = input.getString("Informe a data de encerramento ou se ainda continua: ");
		
		Experience experience = new Experience(profession, description, startDate, endDate);
		experience.show();
		return experience;
	}
	
}

