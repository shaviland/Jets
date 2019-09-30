package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;

public class JetsApplication {
	private AirField airField = new AirField(null);
	private static Scanner kb = new Scanner(System.in);
	private List<Jet> jetList = new ArrayList<>(airField.getJets());

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
			System.out.println("\n************* Menu *************\n" + "1. List fleet\n" + "2. Fly all jets\n"
					+ "3. View fastest jet\n" + "4. View jet with longest range\n" + "5. Load all Cargo Jets\n"
					+ "6. Dogfight!\n" + "7. Add a jet to Fleet\n" + "8. Remove a jet from Fleet\n" + "9. Quit");
			int selection = kb.nextInt();
			quit = menuChoice(selection);
		} while (!quit);
	}

	private boolean menuChoice(int selection) {
//		AirField airField = new AirField(null);
		switch (selection) {
		case 1:
			printJets(jetList);
			break;
		case 2:
			jetsFly(jetList);
			break;
		case 3:
			fastestJet(jetList);
			break;
		case 4:
			longestJet(jetList);
			break;
		case 5:
			loadAllCargoJets(jetList);
			break;
		case 6:
			dogFight(jetList);
			break;
		case 7:
			addNewJet(jetList);
			break;
		case 8:
			removeJet(jetList);
			break;
		case 9:
			System.out.println("GoodBye.");
			replaceList(jetList);
			return true;
		default:
			System.out.println("That is not a valid selection. Please select again.");

		}
		return false;
	}

	public void printJets(List<Jet> jetLists) {
		int i = 1;
		for (Jet printJet : jetList) {
			System.out.println(i++ + ": " + printJet);

		}

	}

	private void jetsFly(List<Jet> jetList) {

		for (Jet jetsFly : jetList) {
			if (jetsFly != null) {
				jetsFly.fly();
			}

		}

	}

	private void fastestJet(List<Jet> jetList) {

		Jet fastestJet = null;
		for (Jet jetsFast : jetList) {
			if (jetsFast != null) {
				if (fastestJet == null || fastestJet.getRange() < jetsFast.getRange()) {
					fastestJet = jetsFast;
				}
			}
		}
		System.out.println(fastestJet.toString());

	}

	private void longestJet(List<Jet> jetList) {

		Jet longestJet = null;
		for (Jet jetsLong : jetList) {
			if (jetsLong != null) {
				if (longestJet == null || longestJet.getSpeed() < jetsLong.getSpeed()) {
					longestJet = jetsLong;
				}
			}
		}
		System.out.println(longestJet.toString());
	}

	public void loadAllCargoJets(List<Jet> jetList) {

		for (Jet cargoSearch : jetList) {
			if (cargoSearch instanceof CargoPlane) {
				CargoPlane cargoLoad = (CargoPlane) cargoSearch;
				cargoLoad.loadCargo();
			}

		}

	}

	private void dogFight(List<Jet> jetList) {

		for (Jet dogFight : jetList) {
			if (dogFight instanceof FighterJet) {
				FighterJet fightingJets = (FighterJet) dogFight;
				fightingJets.fight();
			}

		}

	}

	private void addNewJet(List<Jet>jetList) {

		System.out.println("Enter plane type.\n1: Fighter\n2: Cargo\n3: Passanger\n  ");
		int jetType = kb.nextInt();
		System.out.print("Enter model name: ");
		kb.nextLine();
		String model = kb.nextLine();
		System.out.print("Enter speed in mph: ");
		double speed = kb.nextDouble();
		System.out.print("Enter range in miles: ");
		int range = kb.nextInt();
		System.out.print("Enter price: ");
		long price = kb.nextLong();
		planeType(jetList, jetType, model, speed, range, price);

	}

	private List<Jet> planeType(List<Jet> jetList, int jetType, String model, double speed, int range, long price) {
		switch (jetType) {
		case 1:
			String type = "fighter";
			Jet nj = new FighterJet(type, model, speed, range, price);
			jetList.add(nj);
			break;
		case 2:
			String type2 = "cargo";
			Jet nj2 = new CargoPlane(type2, model, speed, range, price);
			jetList.add(nj2);
			break;
		case 3:
			String type3 = "passanger";
			Jet nj3 = new JetImpl(type3, model, speed, range, price);
			jetList.add(nj3);
			break;
		}
		return jetList;
	}

	private List<Jet> removeJet(List<Jet> jetList) {

		System.out.println("Which Jet would you like to remove? 1 - " + jetList.size());
		printJets(jetList);
		int remove = kb.nextInt();

		jetList.remove(remove - 1);

		return jetList;

	}

	public void replaceList(List<Jet> jetList) {
		try {

			FileWriter fw = new FileWriter("jets.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Jet jetReplace : jetList) {

				pw.println(jetReplace.getType() + ", " + jetReplace.getModel() + ", " + jetReplace.getSpeed() + ", "
						+ jetReplace.getRange() + ", " + jetReplace.getPrice());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}