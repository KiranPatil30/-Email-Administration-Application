package emailapp;
import java.util.Scanner ;
public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String email;
	private String department ;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	// constructor to recive the First and lastName
	public Email(String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;

		
		this.department = setDepartment();
				
		// call a method that return a random password 
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : " + this.password);
		
		// combine element to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}
	//ask for the department 
	private String setDepartment() {
		System.out.println("NEW Worker :"+ firstName +"DEPARTMENT CODE :\n 1.for Sales \n 2.for Development \n 3.for Accounting \n 0.for None \n Enter a Department code :");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if(choice == 1) { return "Sales"; }
		else if(choice == 2 ) { return "dev";}
		else if(choice == 3) { return "Accounting";}
		else {return "";}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int)(Math.random() * passwordSet.length()) ;
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	// set mail box capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	//set alternate email
	public void setAlternateEmail(String altEmail)
	{
		this.alternateEmail =  altEmail;
	}
	// Change the Password
	public void changePassword(String password ) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME :" + firstName +" "+lastName +
				"\nCOMPANY EMAIL :" + email +
				"\nMAILBOX CAPACITY:" + mailboxCapacity + "mb";
	}
	
}
