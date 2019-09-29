package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady {


	public FighterJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		
		System.out.println(super.getModel() + " is doing a barrel roll." );
		System.out.println(super.toString());
		super.flyLength();
		
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fight() {
		System.out.println("Firing missle...");
		System.out.println("Firing onbaord guns.");
		
		
	}

}
