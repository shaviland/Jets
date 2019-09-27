package com.skilldistillery.jets;

public abstract class Jet {
	
	//F I E L D S
	
	private String model;
	private double speed;
	private int range;
	private long price;
	
	//C O N S T R U C T O R S 
	
	public Jet() {

	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	//M E T H O  D S

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public abstract void fly();
	public abstract double getSpeedInMach();
	
}
