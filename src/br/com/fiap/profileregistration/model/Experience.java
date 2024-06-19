package br.com.fiap.profileregistration.model;

public class Experience {
	
	/**
	 * Definindo os campos da classe Experience
	 */
	private String profession;
	private String description;
	private String startDate;
	private String endDate;
	
	public Experience(String profession, String description, String startDate, String endDate) {
		super();
		this.profession = profession;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Apresenta as informações da classe Experience
	 */
	public void show() {
		System.out.println("Profissão: " + this.getProfession() + "\nDescrição:" + getDescription() + "\nComeço do carreira: " + this.getStartDate() + "\nFim do trabalho: " + this.getEndDate());
	}
}
