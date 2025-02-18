# Profile Registration

A necessidade de treinamento prático em técnicas de sutura para médicos residentes tem sido cada vez mais discutida, buscando formas de adaptar essas atividades para um contexto mais tecnológico. Diante dessa proposta, a inteligência artificial se torna uma forte candidata a liderar essa longa jornada de desenvolvimento.  

Com base na ideia sugerida, o **"Suture Lab"** surge como o jogo perfeito para treinar diferentes tipos de sutura, uma técnica de extrema importância e que exige um ótimo domínio. Como forma de apoiar esse jogo, é necessário um sistema para cadastrar os usuários, ou seja, médicos residentes e mentores, em um ambiente simples e de fácil acesso, onde a pessoa poderá acompanhar seu progresso nas práticas realizadas ao longo dos dias.  

Pensando nisso, foi criado um sistema chamado **"Profile Registration"**, que tem como principal função cadastrar o usuário e suas informações principais.  

---

## 🚀 Funcionalidades  

O sistema de registro de perfil foi desenvolvido para auxiliar na criação e gerenciamento de perfis de usuários, especificamente médicos residentes, em um jogo de realidade virtual (VR) voltado para técnicas de sutura. A seguir estão as principais funcionalidades e características do sistema:  

### 🏥 **Professional**  

Essa classe é a principal responsável pelo funcionamento do sistema, pois é com ela que coletamos as informações principais sobre o profissional que está sendo cadastrado.  
Por se tratar de uma **classe abstrata**, ela serve de base para as classes `ResidentDoctor` e `Mentor`, que herdam os campos da classe `Professional`.  
Ela possui uma **interface DAO**, que implementa as funcionalidades de inclusão no banco de dados.  

### 👨‍⚕️ **ResidentDoctor**  

- Classe filha de `Professional`.  
- Contém um **construtor** passando os inúmeros campos para facilitar na hora da instância do profissional.  
- Possui um método que exibe as informações inseridas pelo usuário.  

### 🧑‍🏫 **Mentor**  

- Classe filha de `Professional`.  
- Semelhante à classe `ResidentDoctor`, contém um **construtor** para facilitar a criação de instâncias.  
- Possui um método que exibe as informações inseridas pelo usuário.  

### 📧 **Email**  

- Classe responsável por coletar o e-mail do profissional.  
- Segue os padrões do sistema.  
- Possui uma **interface DAO**, juntamente com uma implementação `DAOImpl`, contendo funcionalidades de **C.R.U.D.**  

### 📍 **Address**  

- Apresenta os campos padrão de um endereço: **rua, cidade, estado, CEP e país**.  
- Coleta as informações referentes ao profissional.  
- Possui uma **interface DAO**, com duas implementações:  
  - **Uma para incluir o endereço.**  
  - **Outra para buscar o ID do profissional cadastrado inicialmente, por meio da classe `ProfessionalDAOImpl`.**  

### ℹ️ **BasicInformation**  

- Permite adicionar informações básicas ao usuário.  
- Possui uma **interface DAO**.  

### 📞 **PhoneNumber**  

- Responsável por adicionar o número de telefone do cadastrado.  
- Segue o mesmo padrão das demais, com uma **interface DAO** e uma implementação `DAOImpl`.  

### 🔍 **ProfessionalDetail**  

- Responsável por **validar o CPF** e detalhar os profissionais, especialmente por meio do método `show`.  

### 🛠 **ConnectionBD**  

- Classe necessária para realizar a **conexão com o banco de dados** por meio do **padrão Singleton**.  
- Nela ocorre a instância da conexão, e as variáveis de **URL, usuário e senha** são criadas e passadas para o **construtor da classe**, responsável pela conexão.  

---

## 📦 **Instalação e Execução**  

Para utilizar o projeto, siga os passos abaixo:  

### 🔹 **Criar as tabelas no banco de dados**
```sh
-- Criando a tabela PROFESSIONAL
CREATE TABLE PROFESSIONAL (
    id NUMBER, 
    name VARCHAR2(20) NOT NULL,
    birthDate DATE NOT NULL,
    institution VARCHAR2(20) NOT NULL,
    cpf VARCHAR2(15) NOT NULL,
    crm VARCHAR2(15) NOT NULL,
    type VARCHAR2(15) NOT NULL,
    CONSTRAINT pk_ID PRIMARY KEY (id),
    CONSTRAINT check_cpf CHECK(LENGTH(cpf) = 14)
);

-- Criando a tabela EMAIL
CREATE TABLE EMAIL (
    professionalID NUMBER,
    mainEmail VARCHAR2(50) NOT NULL,
    otherEmails VARCHAR2(50) NULL,
    CONSTRAINT pk_mainEmail PRIMARY KEY(mainEmail),
    FOREIGN KEY (professionalID) REFERENCES PROFESSIONAL(ID)
);

-- Criando a tabela BASIC_INFORMATION
CREATE TABLE BASIC_INFORMATION (
    professionalID NUMBER,
    description VARCHAR2(300) NOT NULL,
    CONSTRAINT pk_basicinfo PRIMARY KEY (PROFESSIONALID, DESCRIPTION),
    FOREIGN KEY (professionalID) REFERENCES PROFESSIONAL(ID)
);

-- Criando a tabela PHONE_NUMBER
CREATE TABLE PHONE_NUMBER(
    professionalID NUMBER,
    main_phone VARCHAR2 (17) NOT NULL,
    other_phone VARCHAR2(17) NULL,
    CONSTRAINT pk_mainPhone PRIMARY KEY(main_phone),
    FOREIGN KEY (professionalID) REFERENCES PROFESSIONAL(ID)
);

-- Criando a tabela ADDRESS
CREATE TABLE ADDRESS (
    professionalID NUMBER,
    postalCode VARCHAR2(20) PRIMARY KEY,
    street VARCHAR2(100) NOT NULL,
    city VARCHAR2(50) NOT NULL,
    state VARCHAR2(50) NOT NULL,
    country VARCHAR2(50) NOT NULL,
    FOREIGN KEY (professionalID) REFERENCES PROFESSIONAL(ID)
);

-- Criando a sequence para auto incremento
CREATE SEQUENCE professional_seq
  START WITH 1
  INCREMENT BY 1;

-- Criando o trigger para autoincremento do ID
CREATE OR REPLACE TRIGGER professional_id_trigger
BEFORE INSERT ON PROFESSIONAL
FOR EACH ROW
BEGIN
  :NEW.ID := professional_seq.NEXTVAL;
END;

