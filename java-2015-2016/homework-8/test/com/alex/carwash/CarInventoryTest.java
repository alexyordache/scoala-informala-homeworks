package com.alex.carwash;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.alex.homework4.Car;
import com.alex.homework4.Duster;
import com.alex.homework4.Golf;
import com.alex.homework4.Logan;

public class CarInventoryTest {

	@Test
	public void testAddAndRemoveACar() {
		CarInventory ci = new CarInventory();
		ci.addCar(new Logan(15, "asdasd"));
		assertEquals(1, ci.getAllCars().size());
		ci.removeCar("asdasd");
		assertEquals(0, ci.getAllCars().size());
		
	}
	
	@Test
	public void testThatCanRetriveMoestEfficientCars() {
		CarInventory ci = new CarInventory();
		Car logan = new Logan(15, "asdasd");
		Car golf = new Golf(15, "asd123");
		Car duster = new Duster(15, "duster");
		ci.addCar(logan);
		ci.addCar(golf);
		ci.addCar(duster);
		assertEquals(golf, ci.getMostFuelEfficientCars(1).get(0));
	}

}
