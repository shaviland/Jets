package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier {



	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {

		System.out.println(super.getModel() + " is flying like an air manatee.");
		System.out.println(super.toString());
		super.flyLength();
		

	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void loadCargo() {

		System.out.println(this.getModel() + ": Loading cargo.");
		System.out.println("Cargo full.");

	}

}
