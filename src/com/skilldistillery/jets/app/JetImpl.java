package com.skilldistillery.jets.app;

public class JetImpl extends Jet {

	public JetImpl() {
		// TODO Auto-generated constructor stub
	}

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {

		System.out.println( super.getModel() + " is cruising in the air.");
		
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

}
