package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirField {

	// F I E L D S

	private List<Jet> jets;

	// C O N S T R U C T O R S

	public AirField() {
		jets = readNames();
	}

	public AirField(List<Jet> jet) {
		jets = readNames();
	}
	

	// M E T H O D S


	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	public List<Jet> readNames() {

		List<Jet> result = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("jets.txt"));
			String jetList;
			String[] jetSplit;
			while ((jetList = reader.readLine()) != null) {

				jetSplit = jetList.split(", ");
//				String type = jetSplit[0];
				String model = jetSplit[1];
				double speed = Double.parseDouble(jetSplit[2]);
				int range = Integer.parseInt(jetSplit[3]);
				long price = Long.parseLong(jetSplit[4]);

				switch (jetSplit[0]) {
				case "CargoPlane": {
					Jet cp = new CargoPlane(model, speed, range, price);
					result.add(cp);
					break;
				}
				case "FighterJet": {
					Jet fj = new FighterJet(model, speed, range, price);
					result.add(fj);
					break;
				}
				case "JetImpl": {
					Jet ji = new JetImpl(model, speed, range, price);
					result.add(ji);
					break;
				}
				}

			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + reader + ": " + e.getMessage());
		}
		return result;
	}


}
