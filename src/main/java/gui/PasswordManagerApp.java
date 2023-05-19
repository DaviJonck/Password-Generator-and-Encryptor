package gui;

import java.util.InputMismatchException;
import java.util.Scanner;

import application.PasswordDecryptor;
import application.PasswordGenerator;

public class PasswordManagerApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Password Manager APP");
		
		while(true) {
			System.out.println("Please Select an option:");
			System.out.println("1. Generate a Password");
			System.out.println("2. Decrypt Passwords");
			System.out.println("3. Exit");
					
			try {
				int result = sc.nextInt();	
				sc.nextLine();
				
			switch(result) {
			case 1:
				passwordGenerator();
				return;
			case 2:
				passwordDecryptor();
				return;
			case 3:
				System.out.println("Exiting the program. Hope to see you again!");
				return;
			default:
				System.out.println("Invalid Number, can you try again? ");
				break;
			}
		}catch(InputMismatchException e){
			System.out.println("You need to type an number. Please try again! ");
			sc.nextLine();
		}
			sc.close();
		}
		
	}
	private static void passwordGenerator() {
		PasswordGenerator.main(null);
	}
	private static void passwordDecryptor() {
		PasswordDecryptor.main(null);
	}
}



