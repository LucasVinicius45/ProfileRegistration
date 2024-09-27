package br.com.fiap.profileregistration.model;

public class Mentor extends Professional {

	
	public Mentor(int id, String name, String cpf, String birthDate, String institution, String crm, String type) {
		
		this.setId(id);
		this.setName(name);
		this.setCpf(cpf);
		this.setBirthDate(birthDate);
		this.setInstitution(institution);
		this.setCrm(crm);
		this.setType(type);
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Apresenta o usuário
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Usuário: " + this.getName() + "\nCPF:" + getCpf() + "\nData de Nascimento: " + this.getBirthDate() + "\nInstituição de ensino: " + this.getInstitution() + "\nCRM: " + this.getCrm());
	}

}
