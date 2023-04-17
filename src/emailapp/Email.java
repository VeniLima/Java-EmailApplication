package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
	
		this.password = randomPassword(defaultPasswordLength);
			
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
		
	}
	
	private String setDepartment() {
		System.out.println("Novo funcionario " + firstName +". Codigos dos departamentos\n1 para Vendas\n2 para Desenvolvimento\n3 para Contabilidade\n0 para nenhum\nDigite o codigo do departamento");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if(depChoice == 1) {
			return "sales";
		}else if(depChoice == 2) {
			return "dev";
		}else if(depChoice == 3) {
			return "acct";
		}else {
			return "";
		}
	};
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	};
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	};
	
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	};
	
	public void changePassword(String password) {
		this.password = password;
	};
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	};
	
	public String getAlternateEmail() {
		return alternateEmail;
	};
	
	public String getPassword() {
		return password;
	};
	
	public String displayInfo() {
		return "NOME: " + firstName + " " + lastName +
				"\nEMAIL DA EMPRESA: " + email + 
				"\nCAPACIDADE DA CAIXA DE EMAIL: " + mailboxCapacity +  "mb";
 	}
	
}
