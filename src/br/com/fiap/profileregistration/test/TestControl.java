package br.com.fiap.profileregistration.test;

import br.com.fiap.profileregistration.model.ResidentDoctor;
import br.com.fiap.profileregistration.model.Surgeon;
import br.com.fiap.profileregistration.model.Task;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.model.ProfessionalDetail;
import br.com.fiap.profileregistration.model.Email;
import br.com.fiap.profileregistration.model.InputController;
import br.com.fiap.profileregistration.model.PhoneNumber;

import java.util.ArrayList;

import br.com.fiap.profileregistration.model.Adress;
import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Experience;

public class TestControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputController input = new InputController();
		Professional resident = TestControl.showUser(input);
		resident.getDetail().setEmail(TestControl.showEmail(input));
		resident.getDetail().setBasicInformation(TestControl.showBasicInformation(input));
		resident.getDetail().setPhoneNumber(TestControl.showPhoneNumber(input));
		resident.getDetail().setAdress(TestControl.showAdress(input));
		// resident.getDetail().setTask(TestControl.showTask());
		resident.getDetail().setExperience(TestControl.showExperience(input));
		resident.show();
		System.out.println("\n --- REGISTRO GERAL --- ");
		resident.getDetail().show();
		input.closeScanner();
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
		
		double choiceNumber = input.getDouble("Escolha: \n1 - Médico Residente \n2 - Cirurgião");
		String name = input.getString("Digite seu nome: ");
		String cpf = input.getString("Digite seu cpf: ");
		String dateBirth = input.getDate("Data de Nascimento: dd/MM/yyyy ");
		double salary = input.getDouble("Digite seu salário: ");
		String crm = input.getString("Digite seu crm: ");
		// Professional user = new Professional(name, cpf);
		if(choiceNumber == 1) {
			ResidentDoctor resident = new ResidentDoctor(name, cpf, dateBirth, salary, crm);
			
			resident.setDetail(new ProfessionalDetail(cpf));
			resident.show();
			System.out.println("Você escolheu residente");
			return resident;
		} else {
			System.out.println("Você escolheu cirurgião");
			Surgeon surgeon = new Surgeon(name, cpf, dateBirth, salary, crm);
			surgeon.setDetail(new ProfessionalDetail(cpf));
			surgeon.show();
			return surgeon;
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
	 * Mostra o progresso das tarefas printado
	 * @return
	 */
	public static Task showTask() {
		
		Task task = new Task();
		task.calculateProgress();
		task.showProgress();
		return task;
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
