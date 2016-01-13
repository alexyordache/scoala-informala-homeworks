package com.alex.valetparking;

import com.alex.homework4.Car;
import com.alex.homework4.Logan;

public class ValetParkingApp {

	public static void main(String[] args) throws ParkingFullException, ParkingSpaceNotFoundException, CarNotFoundException {

		ValetParking<Car> vehiclePark = new ValetParking<>(50);
		Car car = new Logan(15, "blabla");
		System.out.println(car.getAvailableFuel());
		ParkingTicket ticket = new ParkingTicket(12);
		vehiclePark.parkVehicle(car, ticket);
		System.out.println(car.getAvailableFuel());
		vehiclePark.retriveVehicle(ticket);
		System.out.println(car.getAvailableFuel());

		ValetParking<Motorcycle> motoPark = new ValetParking<>(5);
		Motorcycle motorcycle = new Gsxr(8, "bababa");
		System.out.println(motorcycle.getAvailableFuel());
		ParkingTicket ticket2 = new ParkingTicket(10);
		motoPark.parkVehicle(motorcycle, ticket2);
		System.out.println(motorcycle.getAvailableFuel());
		motoPark.retriveVehicle(ticket2);
		System.out.println(motorcycle.getAvailableFuel());

	}
}
