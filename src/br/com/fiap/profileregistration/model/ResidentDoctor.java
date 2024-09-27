package br.com.fiap.profileregistration.model;

public class ResidentDoctor extends Professional {

	private String crm;

	
	public ResidentDoctor(int id, String name, String cpf, String birthDate, String institution, String crm) {
		
		this.setId(id);
		this.setName(name);
		this.setCpf(cpf);
		this.setBirthDate(birthDate);
		this.setInstitution(institution);
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
	
		System.out.println("Usuário: " + this.getName() + "\nCPF:" + getCpf() + "\nData de Nascimento: " + this.getBirthDate() + "\nSalário: " + this.getInstitution() + "\nCRM: " + this.getCrm());
		//System.out.println(validateDate(getBirthDate()));
	}
}
