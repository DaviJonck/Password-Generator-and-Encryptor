package application;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Scanner;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordGenerator {
	
	private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
	
	
	private static final String ACCESS_PASSWORD = "teste";
	

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);	
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter access password: ");
		String accessInput = sc.nextLine();
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("encryptionPassword");		
		
		
		if(accessInput.equals(ACCESS_PASSWORD)) {
			int length = getPasswordLength();
			boolean useUppercase = getCharacterType("INCLUDE UPPER CASE ? (S/N)");
			boolean useLowercase = getCharacterType("INCLUDE LOWER CASE ? (S/N)");
			boolean useNumbers = getCharacterType("INCLUDE NUMBERS ? (S/N)");
			boolean useSpecialCharacters = getCharacterType("INCLUDE SPECIAL CHARACTERS ? (S/N)");
			
			String password = generatePassword(length , useUppercase , useLowercase, useNumbers, useSpecialCharacters);
			System.out.println("Password Generate: " + password);
			System.out.println("DESCRIPTION FOR THE PASSWORD:");
			String description = sc.nextLine();
			savePasswordToFile(textEncryptor.encrypt(password),textEncryptor.encrypt(description));
		} else {
			System.out.println("INVALID PASSWORD. ACCESS DENIED");
		}	
	}		
		public static int getPasswordLength() {
			
			Scanner sc = new Scanner(System.in);
		
		System.out.print("Type the size of the password you want: ");
		String input = sc.nextLine();
		 
		try {
			int length = Integer.parseInt(input);
		if(length <= 0) {
			System.out.println("Wrong Size! Password need to have atleast 1 characters");
			return getPasswordLength();
		}else {
			return length;
		}
	}catch(NumberFormatException e) {
		System.out.println("Invalid Input, type a number: ");
		return getPasswordLength();
	}	
}
	public static boolean getCharacterType(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		
		while(true) {
			String input = sc.nextLine().trim().toUpperCase();
			if(input.equals("S")) {
				return true;
				
			}else if(input.equals("N")) {
				return false;
			} else {
				System.out.println("Wrong Character. Press (S) or (N)");
			}
		}
		
	}
	
	public static String generatePassword(int length, boolean useUppercase,
											boolean useLowercase, boolean useNumbers,
												boolean useSpecialCharacters) {
		
		StringBuilder validCharacters = new StringBuilder();
		
		if(useUppercase) {		
			validCharacters.append(UPPERCASE_LETTERS);
		}
		if(useLowercase) {
			validCharacters.append(LOWERCASE_LETTERS);		
		}
		if(useNumbers) {
			validCharacters.append(NUMBERS);			
		}
		if(useSpecialCharacters) {
			validCharacters.append(SPECIAL_CHARACTERS);
		}																							
		
		if(validCharacters.isEmpty()) {
			throw new IllegalArgumentException("You must select at least one character type ");
		
	}
	
		
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		
		for(int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(validCharacters.length());
			char randomChar = validCharacters.charAt(randomIndex);
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
		public static  void savePasswordToFile(String password, String description) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path where you want to save your password (EX: C:\\documents\\password.csv): ");
		String sourceFileStr = sc.nextLine();
		
		boolean sourceFileStrValid = false;
		while(!sourceFileStrValid) {
		try(FileWriter writer = new FileWriter(sourceFileStr, true)){
			writer.append(password);
			writer.append(" , ");
			writer.append(description);
			writer.append(System.lineSeparator());
			System.out.println("PASSWORD SAVED");
			sourceFileStrValid = true;
		} catch(IOException e) {
			System.out.println("Error when saving the password \nType the file path again: ");
			
			sourceFileStr = sc.nextLine();
			
		}
	}		
}
		
				
}
	
