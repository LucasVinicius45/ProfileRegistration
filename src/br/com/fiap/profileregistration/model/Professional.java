package br.com.fiap.profileregistration.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public abstract class Professional {
	
	/**
	 * Criando os campos da classe usuário para cadastro
	 */
	// protected ProfessionalDetail detail;
	private int id;
	private String name;
	private String cpf;
	private String birthDate;
	private String institution;
	private String type; 
	private String crm;
	private ProfessionalDetail detail;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public ProfessionalDetail getDetail() {
		return detail;
	}

	public void setDetail(ProfessionalDetail detail) {
		this.detail = detail;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	/**
	 * Registra as informações básicas do usuário, dando um print na tela
	 */
	public abstract void show();
	/**
	 * Realizando a validação da data de nascimento por meio do dateTime
	 */
	public boolean validateBirthDate(String strDate) {
		String dateFormat = "dd/MM/uuuu";
		setBirthDate(dateFormat);

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(getBirthDate())
	    .withResolverStyle(ResolverStyle.STRICT);
	    try {
	        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
	        return true;
	    } catch (DateTimeParseException e) {
	       throw new Error("Digite uma data válida: dd/MM/uuuu");
	    } 
	}

	
	
	
	
}
