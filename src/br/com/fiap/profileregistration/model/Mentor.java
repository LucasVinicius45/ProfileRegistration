package br.com.fiap.profileregistration.model;

public class Mentor extends Professional {

	private String crm;
	
	public Mentor(String name, String cpf, String birthDate, String institution, String crm) {
		
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
	 * Apresenta o usuário
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Usuário: " + this.getName() + "\nCPF:" + getCpf() + "\nData de Nascimento: " + this.getBirthDate() + "\nInstituição de ensino: " + this.getInstitution() + "\nCRM: " + this.getCrm());
	}

}
