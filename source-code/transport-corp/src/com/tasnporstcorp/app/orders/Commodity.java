package com.tasnporstcorp.app.orders;

public class Commodity {

	public String name;
	public double lengthCm;
	public double widthCm;
	public double depthCm;

	/**
	 * 
	 * @param name
	 * @param lengthCm
	 * @param widthCm
	 * @param depthCm
	 */
	public Commodity(String name, double lengthCm, double widthCm, double depthCm) {
		this.name = name;
		this.lengthCm = lengthCm;
		this.widthCm = widthCm;
		this.depthCm = depthCm;
	}

	public double getVolumeCm3() {
		// TODO - implement Commodity.getVolumeCm3
		throw new UnsupportedOperationException();
	}

}