package com.skilldistillery.jets.app;

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
			return true;
		default:
			System.out.println("That is not a valid selection. Please select again.");

		}
		return false;
	}

	public void printJets(List<Jet> jetLists) {
		for (Jet printJet : jetList) {

			System.out.println(printJet);
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
				FighterJet cargoLoad = (FighterJet) dogFight;
				cargoLoad.fight();
			}

		}

	}

	private List<Jet> addNewJet(List<Jet> jetList) {

		System.out.println("Enter plane type. (Fighter, Cargo, Passanger");
		String type = kb.next();
		Jet nj = planeType(type);
		System.out.print("Enter model name: ");
		kb.nextLine();
		String model = kb.nextLine();
		nj.setModel(model);
		System.out.print("Enter speed in mph: ");
		String speed = kb.nextLine();
		nj.setSpeed(Double.parseDouble(speed));
		System.out.print("Enter range in miles: ");
		String range = kb.nextLine();
		nj.setRange(Integer.parseInt(range));
		System.out.print("Enter price: ");
		String price = kb.nextLine();
		nj.setPrice(Long.parseLong(price));
		jetList.add(nj);
		return jetList;

	}

	private Jet planeType(String type) {
		if (type.equalsIgnoreCase("fighter")) {
			return new FighterJet();
		} else if (type.equalsIgnoreCase("cargo")) {
			return new CargoPlane();
		} else {
			return new JetImpl();
		}

	}

	private List<Jet> removeJet(List<Jet> jetList) {

		System.out.println("Which Jet would you like to remove? 1 - " + jetList.size());
		int remove = kb.nextInt();

		jetList.remove(remove - 1);

		return jetList;

	}

}
