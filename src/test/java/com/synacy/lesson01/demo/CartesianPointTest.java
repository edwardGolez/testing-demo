package com.synacy.lesson01.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianPointTest {

	@Test
	public void distanceFromOrigin_shouldReturnDistanceFromOrigin() throws Exception {

		CartesianPoint point = new CartesianPoint(2.5, -3.2);

		double result = point.distanceFromOrigin();

		assertEquals(4.061, result, 0.001);
	}

	@Test
	public void testDistance_shouldReturnDistanceBetweenTwoPoints() throws Exception {
		CartesianPoint point1 = new CartesianPoint(1.4, -0.8);
		CartesianPoint point2 = new CartesianPoint(0, -3.2);

		double result = point1.distance(point2);

		assertEquals(2.778, result, 0.001);
	}
}