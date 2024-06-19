package br.com.fiap.profileregistration.model;

public class ResidentDoctor extends Professional {

	private String crm;

	
	public ResidentDoctor(String name, String cpf, String birthDate, double salary, String crm) {
		
		this.setName(name);
		this.setCpf(cpf);
		this.setBirthDate(birthDate);
		this.setSalary(salary);
		this.setCrm(crm);
		// TODO Auto-generated constructor stub
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
	@Override
	public void show() {
	
		System.out.println("Usuário: " + this.getName() + "\nCPF:" + getCpf() + "\nData de Nascimento: " + this.getBirthDate() + "\nSalário: " + this.getSalary() + "\nCRM: " + this.getCrm());
		//System.out.println(validateDate(getBirthDate()));
	}
}
