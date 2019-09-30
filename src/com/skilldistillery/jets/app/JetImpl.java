package com.skilldistillery.jets.app;

public class JetImpl extends Jet {

	public JetImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JetImpl(String type, String model, double speed, int range, long price) {
		super(type = "passanger", model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {

		System.out.println(super.getModel() + " is cruising in the air.");
		System.out.println(super.toString());
		super.flyLength();
		
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

}