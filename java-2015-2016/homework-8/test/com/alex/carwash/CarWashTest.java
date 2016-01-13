package com.alex.carwash;

import org.junit.Test;

import com.alex.homework4.Logan;

public class CarWashTest {

	@Test(expected = Exception.class)
	public void testCantWashCarIfIsClosed() throws Exception {
		CarWash cw = new CarWash();
		cw.washCar();
	}
	
	@Test(expected = Exception.class)
	public void testCantWashCarIfThereIsNoCarInLine() throws Exception {
		CarWash cw = new CarWash();
		cw.openShop();
		cw.washCar();
	}
	
	@Test(expected = Exception.class)
	public void testCantAddCarIfShopIsClosed() throws Exception {
		CarWash cw = new CarWash();
		cw.standInLine(new Logan(12, "asdasd"));
	}
}
