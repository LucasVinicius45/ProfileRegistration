package br.com.fiap.profileregistration.view;

import br.com.fiap.profileregistration.dao.AddressDAOImpl;
import br.com.fiap.profileregistration.dao.BasicInformationDAOImpl;
import br.com.fiap.profileregistration.dao.EmailDAOImpl;
import br.com.fiap.profileregistration.dao.PhoneNumberDAOImpl;
import br.com.fiap.profileregistration.dao.ProfessionalDAOImpl;
import br.com.fiap.profileregistration.model.Address;
import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Email;
import br.com.fiap.profileregistration.model.InputController;
import br.com.fiap.profileregistration.model.Mentor;
import br.com.fiap.profileregistration.model.PhoneNumber;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.model.ProfessionalDetail;
import br.com.fiap.profileregistration.model.ResidentDoctor;

public class TestControl {

    public static void main(String[] args) {
        InputController input = new InputController();
        
        ProfessionalDAOImpl professionalDAO = new ProfessionalDAOImpl();
        Professional professional = null;
        
		try {
			professional = TestControl.showUser(input, professionalDAO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        professionalDAO.includesProfessional(professional);  // O ID será gerado automaticamente

        // Agora que o ID foi gerado, podemos usar o ID correto para inserir os e-mails, telefones, etc.
        Email email = TestControl.showEmail(input);
        EmailDAOImpl emailDAO = new EmailDAOImpl();
        emailDAO.includesEmail(professional, email);

        BasicInformation information = TestControl.showBasicInformation(input);
        BasicInformationDAOImpl basicInformationDAO = new BasicInformationDAOImpl();
        basicInformationDAO.includesInformation(professional, information);

        PhoneNumber number = TestControl.showPhoneNumber(input);
        PhoneNumberDAOImpl phoneNumberDAO = new PhoneNumberDAOImpl();
        phoneNumberDAO.includesPhone(professional, number);
        
        Address address = TestControl.showAdress(input);
        AddressDAOImpl addressDAO = new AddressDAOImpl();
        addressDAO.includesAdress(professional, address);
		
        
        System.out.println("Cadastro realizado com sucesso");
        
        input.closeScanner();
    }

    public static Email showEmail(InputController input) {
        System.out.println("\n--- EMAIL ---");
        Email email = new Email();
        email.register(input);
        return email;
    }

    public static PhoneNumber showPhoneNumber(InputController input) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.register(input);
        return phoneNumber;
    }

    public static Professional showUser(InputController input, ProfessionalDAOImpl professionalDAO) throws Exception {
        double choiceNumber = 0;

        do {
            choiceNumber = input.getDouble("Escolha: \n1 - Médico Residente \n2 - Mentor");
        } while (choiceNumber != 1 && choiceNumber != 2);

        ProfessionalDetail detail = new ProfessionalDetail();
        String name = input.getString("Digite seu nome: ");
        String cpf = detail.registerCPF(input);
        boolean existUser = professionalDAO.searchIDByCPF(cpf);
        System.out.println(existUser);
        if(existUser == true) {
        	throw new Exception("Já existe um usuário com esse cpf");
        }
        String dateBirth = input.getDate("Data de Nascimento: dd/MM/yyyy ");
        String institution = input.getString("Digite sua instituição de ensino: ");
        String crm = input.getString("Digite seu CRM: ");

        if (choiceNumber == 1) {
            ResidentDoctor resident = new ResidentDoctor(name, cpf, dateBirth, institution, crm, "Residente");
            resident.setDetail(detail);
            resident.show();
            return resident;
        } else {
            Mentor mentor = new Mentor(name, cpf, dateBirth, institution, crm, "Mentor");
            mentor.setDetail(detail);
            mentor.show();
            return mentor;
        }
    }

    public static BasicInformation showBasicInformation(InputController input) {
        System.out.println("\n--- INFORMAÇÕES BÁSICAS --- ");
        BasicInformation information = new BasicInformation();
        information.register(input);
        return information;
    }

    public static Address showAdress(InputController input) {
        System.out.println("\n--- ENDEREÇO --- ");
        String country = input.getString("Informe seu País: ");
        String state = input.getString("Informe seu estado: ");
        String city = input.getString("Informe sua cidade: ");
        String postalCode = input.getString("Informe seu CEP: ");
        String street = input.getString("Informe sua Rua e complemento: ");
        
        Address address = new Address(street, city, state, postalCode, country);
        address.show();
        return address;
    }

}
