package com.alex.homework4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private Car logan;

	@Before
	public void setup() {
		logan = new Logan(33, "123asd");
	}

	@Test
	public void testStartMethod() {
		logan.start();
		float delta = 0;
		float expected = 0;
		float actual = logan.getCurrentConsumption();
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testShiftGearMethod() {
		logan.start();
		logan.shiftGear(1);
		int actual = logan.getCurrentGear();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDriveMethod() {
		logan.start();
		logan.shiftGear(1);
		logan.drive(10);
		double actual = logan.getCurrentKm();
		double expected = 10;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculateConsumptionMethod() {
		logan.start();
		logan.shiftGear(2);
		logan.drive(100);
		logan.calculateConsumption(100, 2);
		double actual = logan.getCurrentConsumption();
		double expected = Math.round(8.12 * 100) / 100f;
		// System.out.println("actual: " + Math.round(actual * 100) / 100f);
		assertEquals(expected, actual, 0.12);
	}

	@Test
	public void testUpdateAvailableFuel() {
		logan.start();
		logan.shiftGear(3);
		logan.drive(100);
		float updateAvailableFuelAmount = logan.getAvailableFuel() - logan.getCurrentConsumption();
		float actual = updateAvailableFuelAmount;
		float expected = Math.round(26.22 * 100) / 100f;
		assertEquals(expected, actual, 0.22);
	}
	
	@Test
	public void testAvailableFuel() {
		logan.start();
		logan.shiftGear(2);
		logan.drive(100);
		float actual = logan.getAvailableFuel();
		float expected = 33;
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testAvailableFuelSmaller0() {
		logan = new Logan(0, "123asd");
		logan.start();
		logan.shiftGear(2);
		logan.drive(10);
		float actual = logan.getAvailableFuel();
		float expected = 0;
		assertEquals(expected, actual, 0);
	}
}
