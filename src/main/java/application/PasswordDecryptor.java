package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordDecryptor {


	private static final String ACCESS_PASSWORD= "decryptPasswords";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter the access password: ");
		String accessInput = sc.nextLine();
		
	if(accessInput.equals(ACCESS_PASSWORD)) {
		System.out.println("Enter the file path of the ecrypted passwords: ");
		String filePath = sc.nextLine();
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("encryptionPassword");
	
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			
			File outputFile = new File("C:\\Users\\davij\\OneDrive\\Área de Trabalho\\decrypted_password.csv");
			
			PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] parts = line.split(" ,");
			if(parts.length == 2) {
				String encryptedPassword = parts[0].trim();
				String encryptedDescription = parts[1].trim();
				String password = textEncryptor.decrypt(encryptedPassword);
				String description = textEncryptor.decrypt(encryptedDescription);
				System.out.println("Password: " + password);
				System.out.println("Description: " + description);
				
				writer.println(password + " , " + description);
			}
		}	
	writer.close();	
	
	System.out.println("Decrypted password file created at: " + outputFile.getAbsolutePath());
	System.out.println("In 30s the files will be deleted");
	
	ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	 executorService.schedule(() -> {
		if(outputFile.exists()) {
			try {
				Files.delete(outputFile.toPath());
				System.out.println("Temporary Files Deleted");
					}catch(IOException e) {
						System.out.println("Error deleting temporary File");
					}
		}
		executorService.shutdown();
	 },30, TimeUnit.SECONDS);
	 
		}catch(IOException e) {
			System.out.println("Error reading password from file: " + e.getMessage());
	}
		}else {
			System.out.println("Invalid Password. Access Denied");
			PasswordDecryptor.main(null);
		}
				
	sc.close();
	}
}
