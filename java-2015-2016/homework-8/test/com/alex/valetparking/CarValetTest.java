package com.alex.valetparking;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import com.alex.homework4.Car;
import com.alex.homework4.DummyCar;
import com.alex.homework4.Duster;
import com.alex.homework4.Logan;
import com.alex.homework4.Passat;

public class CarValetTest {

	private ValetParking<Car> valetParking;
	private Car logan;
	private Car passat;
	private Car duster;

	@Before
	public void setup() {
		valetParking = new ValetParking<Car>(3);
		logan = new Logan(10, "abecedar");
		passat = new Passat(15, "abecebar");
		duster = new Duster(20, "abcwar");

	}

	@Test(expected = ParkingFullException.class)
	public void testGivenParkingFullParkCarThrowsException() throws ParkingFullException {
		valetParking.parkVehicle(logan, new ParkingTicket(2));
		valetParking.parkVehicle(passat, new ParkingTicket(4));
		valetParking.parkVehicle(duster, new ParkingTicket(6));

		valetParking.parkVehicle(new Logan(20, "blabla"), new ParkingTicket(8));
	}

	@Test
	public void testGivenParkingHaveSpaceWhenCarIsPerkedEverythingOk() throws ParkingFullException {
		valetParking.parkVehicle(logan, new ParkingTicket(2));
		valetParking.parkVehicle(passat, new ParkingTicket(4));

		valetParking.parkVehicle(new Logan(20, "blabla"), new ParkingTicket(8));

	}

	@Test(expected = ParkingSpaceNotFoundException.class)
	public void testGivenCarIsRequestedWithWrongTicketExceptionIsTrown() throws ParkingFullException, ParkingSpaceNotFoundException, CarNotFoundException {
		valetParking.parkVehicle(logan, new ParkingTicket(2));
		valetParking.parkVehicle(passat, new ParkingTicket(4));

		ParkingTicket pt = new ParkingTicket(8);
		valetParking.parkVehicle(new Logan(20, "blabla"), pt);
		
		valetParking.retriveVehicle(new ParkingTicket(8));
	}
	
	@Test
	public void testGivenCarIsRequestedWithGoodTicketEverythingOk() throws ParkingFullException, ParkingSpaceNotFoundException, CarNotFoundException {
		ParkingTicket ptLogan = new ParkingTicket();
		ParkingTicket ptPassat = new ParkingTicket();
		ParkingTicket ptDuster = new ParkingTicket();
		valetParking.parkVehicle(logan, ptLogan);
		valetParking.parkVehicle(passat, ptPassat);
		valetParking.parkVehicle(duster, ptDuster);
		Car c1 = valetParking.retriveVehicle(ptLogan);
		Car c2 = valetParking.retriveVehicle(ptPassat);
		Car c3 = valetParking.retriveVehicle(ptDuster);
		assertEquals(logan, c1);
		assertEquals(passat, c2);
		assertEquals(duster, c3);
	}
}
