package br.com.fiap.profileregistration.view;

import br.com.fiap.profileregistration.dao.BasicInformationDAOImpl;
import br.com.fiap.profileregistration.dao.EmailDAOImpl;
import br.com.fiap.profileregistration.dao.PhoneNumberDAOImpl;
import br.com.fiap.profileregistration.dao.ProfessionalDAOImpl;
import br.com.fiap.profileregistration.model.Adress;
import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Email;
import br.com.fiap.profileregistration.model.Experience;
import br.com.fiap.profileregistration.model.InputController;
import br.com.fiap.profileregistration.model.Mentor;
import br.com.fiap.profileregistration.model.PhoneNumber;
import br.com.fiap.profileregistration.model.Professional;
import br.com.fiap.profileregistration.model.ProfessionalDetail;
import br.com.fiap.profileregistration.model.ResidentDoctor;

public class TestControl {

    public static void main(String[] args) {
        InputController input = new InputController();
    
        Professional professional = TestControl.showUser(input);
        ProfessionalDAOImpl professionalDAO = new ProfessionalDAOImpl();
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
        
        // Buscar ID por CPF
        professionalDAO.searchIDByCPF(professional);
        
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

    public static Professional showUser(InputController input) {
        double choiceNumber = 0;

        do {
            choiceNumber = input.getDouble("Escolha: \n1 - Médico Residente \n2 - Mentor");
        } while (choiceNumber != 1 && choiceNumber != 2);

        ProfessionalDetail detail = new ProfessionalDetail();
        String name = input.getString("Digite seu nome: ");
        String cpf = detail.registerCPF(input);
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

    public static Adress showAdress(InputController input) {
        System.out.println("\n--- ENDEREÇO --- ");
        String country = input.getString("Informe seu País: ");
        String state = input.getString("Informe seu estado: ");
        String city = input.getString("Informe sua cidade: ");
        String postalCode = input.getString("Informe seu CEP: ");
        String street = input.getString("Informe sua Rua e complemento: ");
        
        Adress adress = new Adress(street, city, state, postalCode, country);
        adress.show();
        return adress;
    }

    public static Experience showExperience(InputController input) {
        System.out.println("\n--- EXPERIÊNCIAS ---");
        String profession = input.getString("Informe sua profissão: ");
        String description = input.getString("Informe uma breve descrição: ");
        String startDate = input.getString("Informe a data de início de sua carreira: ");
        String endDate = input.getString("Informe a data de encerramento ou se ainda continua: ");

        Experience experience = new Experience(profession, description, startDate, endDate);
        experience.show();
        return experience;
    }
}
