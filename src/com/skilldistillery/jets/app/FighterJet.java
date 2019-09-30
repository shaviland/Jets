package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type = "fighter", model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {

		System.out.println(super.getModel() + " is doing a barrel roll.");
		System.out.println(super.toString());
		super.flyLength();

	}

	@Override
	public void fight() {
		if (Math.random() > .5) {
			System.out.println(this.getModel() + ": Firing missle...");
		} else {
			System.out.println(this.getModel() + ": Firing onbaord guns.");
		}

	}

}
