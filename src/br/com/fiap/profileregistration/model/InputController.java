package br.com.fiap.profileregistration.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
public class InputController {
	/**
	 * Classe que age como um controle de scanner, facilitando na chamada para uma pergunta e passagem de informações
	 */
	Scanner scanner; 
	
	// Abre o scanner
	public InputController() {
		this.scanner = new Scanner(System.in);
	}
	
	// Método que irá fechar o Scanner
	public void closeScanner() {
        this.scanner.close();
    }
	
	// Passa uma mensagem String para o scanner
	public int getInt(String message) {
		System.out.println(message);
		while (true) {
			if (this.scanner.hasNextInt()) {
                int input = this.scanner.nextInt();
                this.scanner.nextLine();
                
                return input;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro:");
                this.scanner.nextLine(); 
            }
		}
	}
	
	// Passa uma mensagem double para o scanner
	public double getDouble(String message) {
		System.out.println(message);
		while (true) {
			if (this.scanner.hasNextDouble()) {
                double input = this.scanner.nextDouble();
                this.scanner.nextLine();
                return input;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número double:");
                this.scanner.nextLine(); 
            }
		}
		
	}
	
	// Passa uma mensagem em formato de data para o scanner
	public String getDate(String message) {
		System.out.println(message);
        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (!input.isEmpty() && this.isValidDate(input)) {
                    return input;
                } else {
                    System.out.println("Entrada vazia ou data inválida. Insira novamente:");
                    
                    
                }
            }
        }
	}
	
	// Valida a data
	public boolean isValidDate(String date) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(date, formatter);    
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }   
	   }
	
	// Passa uma mesagem booleana
	public boolean getBoolean(String message) {
		System.out.println(message);
		while (true) {
			if (this.scanner.hasNextBoolean()) {
                boolean input = this.scanner.nextBoolean();
                this.scanner.nextLine();
                return input;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um boolean:");
                this.scanner.nextLine(); 
            }
		}
	}
	
	public String getString(String message) {
		System.out.println(message);
        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.out.println("Entrada vazia. Por favor, insira um texto:");
                }
            }
        }
    }
}
