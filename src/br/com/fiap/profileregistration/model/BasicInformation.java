package br.com.fiap.profileregistration.model;

public class BasicInformation {
	
	/**
	 * definindo campo da classe BasicInformation
	 */
	private String description = "default description";
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Apresenta uma opção de inserir descrição opcional
	 * @param input
	 */
	public void register(InputController input) {
		// TODO Auto-generated method stub
		
		boolean putDescription = input.getBoolean("Deseja iserir uma descrição? true or false");
		if(putDescription) {
			String description = input.getString("Insira a descrição: ");
			setDescription(description);
			
		} 
		this.show();
		
	}
	/**
	 * Apresenta a descrição descrita
	 */
	public void show() {
		System.out.println("Descrição: " + this.description);
	}
}
