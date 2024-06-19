package br.com.fiap.profileregistration.model;

public class ProfessionalDetail {
	
	private String cpfProfessional;
	private Experience experinece;
	private Experience experience;
	private Task task;
	private Email email;
	private PhoneNumber phoneNumber;
	private BasicInformation basicInformation;
	private Adress adress;
	
	public ProfessionalDetail(String cpfProfessional) {
		this.cpfProfessional = cpfProfessional;
	}
	
	public String getCpfProfessional() {
		return cpfProfessional;
	}
	public void setCpfProfessional(String cpfProfessional) {
		this.cpfProfessional = cpfProfessional;
	}
	public Experience getExperinece() {
		return experinece;
	}
	public void setExperinece(Experience experinece) {
		this.experinece = experinece;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
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
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public void show() {
		System.out.println("CPF: "+ this.getCpfProfessional());
		this.getEmail().show();
		this.getPhoneNumber().show();
		this.getBasicInformation().getDescription();
		this.getAdress().show();		
		// System.out.printf(" Email: %s,  ", this.getTask().get());
	}
	
}
