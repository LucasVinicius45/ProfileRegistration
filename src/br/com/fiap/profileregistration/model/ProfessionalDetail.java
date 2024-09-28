package br.com.fiap.profileregistration.model;

public class ProfessionalDetail {
	
	private String cpfProfessional;
	private Email email;
	private PhoneNumber phoneNumber;
	private BasicInformation basicInformation;
	private Address adress;
	
	public ProfessionalDetail(String cpfProfessional) {
		this.cpfProfessional = cpfProfessional;
	}
	
	public ProfessionalDetail() {
		
	}
	
	public String getCpfProfessional() {
		return cpfProfessional;
	}
	public void setCpfProfessional(String cpfProfessional) {
		this.cpfProfessional = cpfProfessional;
	}
	
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}
	public void setBasicInformation(BasicInformation basicInformation) {
		this.basicInformation = basicInformation;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	/**
	 * apresenta os detalhes do cadastro
	 */
	public void show() {
		System.out.println("CPF: "+ this.getCpfProfessional());
		this.getEmail().show();
		this.getPhoneNumber().show();
		this.getBasicInformation().getDescription();
		this.getAdress().show();		
		// System.out.printf(" Email: %s,  ", this.getTask().get());
	}
	/**
	 * Registra o cpf
	 * @param input
	 * @return
	 */
	public String registerCPF(InputController input) {
	    String cpf;
	    do {
	        cpf = input.getString("Digite um CPF válido, ex: XXX.XXX.XXX-XX");
	        if (!this.isCPF(cpf)) {
	            System.out.println("CPF inválido. Tente novamente.");
	        }
	    } while (!this.isCPF(cpf)); // Repete até CPF válido

	    this.setCpfProfessional(cpf);
	    return cpf;
	}

	
	/**
	 * Valida o cpf
	 * @param cpf
	 * @return
	 */
	 public boolean isCPF(String cpf) {
	        // Remove caracteres não numéricos
	        cpf = cpf.trim().replaceAll("[^\\d]", "");

	        // Verifica se o CPF tem 11 dígitos
	        if (cpf.length() != 11) {
	            return false;
	        }

	        // Verifica se todos os dígitos são iguais (ex: 11111111111)
	        if (cpf.matches("(\\d)\\1{10}")) {
	            return false;
	        }
	        return true;
     
	 }
}