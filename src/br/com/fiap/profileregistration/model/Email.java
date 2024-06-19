package br.com.fiap.profileregistration.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	
	/**
	 * utilizando o pattern para validaar o email
	 */
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	
	/**
	 * Definindo o campo de email
	 */
	private String name;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Valida se o email está escrito da maneira padrão de um email e o registra
	 * @param input
	 */
	public void register(InputController input) {
		// TODO Auto-generated method stub
		String name = input.getString("Digite um email: ");
		if(Email.validateEmail(name)) {
			this.setName(name);
			this.show();
		} else {
			System.out.println("Email inválido");
			this.register(input);
			
		}
		
	}
	/**
	 * mostra o email registrado
	 */
	public void show() {
		System.out.println("Email: " + name);
	}
	
	/**
	 * Matcher para validar o email no padrão correto
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email){
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	 }
	
}
