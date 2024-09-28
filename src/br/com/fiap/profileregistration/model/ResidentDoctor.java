package br.com.fiap.profileregistration.model;

public class ResidentDoctor extends Professional {

	

	
	public ResidentDoctor(String name, String cpf, String birthDate, String institution, String crm, String type) {
		
		this.setName(name);
		this.setCpf(cpf);
		this.setBirthDate(birthDate);
		this.setInstitution(institution);
		this.setCrm(crm);
		this.setType(type);
		// TODO Auto-generated constructor stub
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
