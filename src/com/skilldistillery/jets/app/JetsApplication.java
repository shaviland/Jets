package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;

public class JetsApplication {
	private AirField airField;
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();

		ja.launch();
		kb.close();
		
	}

	private void launch() {

		displayUserMenu();

	}

	private void displayUserMenu() {
		boolean quit = false;
		do {
		System.out.println("************* Menu *************\n" + "1. List fleet\n" + "2. Fly all jets\n" + "3. View fastest jet\n" + "4. View jet with longest range\n"
				+ "5. Load all Cargo Jets\n" + "6. Dogfight!\n" + "7. Add a jet to Fleet\n" + "8. Remove a jet from Fleet\n"
				+ "9. Quit");
		int selection = kb.nextInt();
		quit = menuChoice(selection);
		}while(!quit);
	}

	private boolean menuChoice(int selection) {
		AirField airField = new AirField();
		switch(selection) {
		case 1:
			airField.printJets();
			break;
		case 2:
			
			for (Jet jetsFly : airField.getJets()) {
				if(jetsFly != null) {
				jetsFly.fly();
				}
				
			}
			
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		default:
			System.out.println("That is not a valid selection. Please select again.");
		
		}
		return false;
	}

}
