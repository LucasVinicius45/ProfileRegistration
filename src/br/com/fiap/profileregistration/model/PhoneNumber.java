package br.com.fiap.profileregistration.model;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class PhoneNumber {
	
	/**
	 * Pattern para validar o número de celular
	 */
	private static final String PHONE_PATTERN = 
	        "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$";
	
	private static final Pattern pattern = Pattern.compile(PHONE_PATTERN, Pattern.CASE_INSENSITIVE);
	
	private String digit;

	public String getDigit() {
		return digit;
	}

	public void setDigit(String phoneNumber) {
		this.digit = phoneNumber;
	}
	
	/**
	 * Passa um número de celular, valida se ele está escrito da maneira correta e o registra
	 * @param input
	 */
	public void register(InputController input) {
		// TODO Auto-generated method stub
		String phoneNumber = input.getString("Digite um número de celular neste formato: \n(xx) xxxxx-xxxx ");
		if(PhoneNumber.validatePhoneNumber(phoneNumber)) {
			
			this.setDigit(phoneNumber);
			this.show();
			
		} else {
			System.out.println("Número inválido");
			this.register(input);
			
		}
		
		
	}
	
	/**
	 * Apresenta o número de celular
	 */
	public void show() {
		System.out.println("Número de celular: " + this.digit);
	}
	
	/**
	 * Valida o número de celular
	 * @param phoneNumber
	 * @return
	 */
	public static boolean validatePhoneNumber(String phoneNumber){
	    Matcher matcher = pattern.matcher(phoneNumber);
	    return matcher.matches();
	 }
}
