package com.synacy.lesson01.demo;

public class CartesianPoint {

	private double x;
	private double y;

	public CartesianPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceFromOrigin() {
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}

	public double distance(CartesianPoint otherPoint) {
		return Math.sqrt(Math.pow(x - otherPoint.x, 2) + Math.pow(y - otherPoint.y, 2));
	}

}
