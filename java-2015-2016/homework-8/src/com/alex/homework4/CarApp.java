package com.alex.homework4;

public class CarApp {

	public static void main(String[] args) {
		Car car = new Logan(26, "012345ASDFG67890QW");
		car.start();
		car.shiftGear(1);
		car.drive(2);
		car.shiftGear(2);
		car.drive(6);
		car.shiftGear(3);
		car.drive(6);
		car.shiftGear(4);
		car.drive(6);
		car.shiftGear(5);
		car.drive(10);
		car.shiftGear(2);
		car.drive(2);
		car.stop();

		float availableFuel = car.getAvailableFuel();
		System.out.println("Available fuel is: " + availableFuel);

		float fuelConsumedKm = car.getAverageFuelConsumption();
		System.out.println("Average fuel consumed is: " + fuelConsumedKm);

		float pollutionKm = car.getPollution();
		System.out.println("Pollution per km is: " + pollutionKm);

		Vehicle vehicle = new Golf(12, "012345ASDFG67890ER");
		vehicle.start();
		vehicle.drive(1);
		vehicle.stop();

		Car carVehicle = (Car) vehicle;
		availableFuel = carVehicle.getAvailableFuel();
		System.out.println("Available fuel is: " + availableFuel);

		fuelConsumedKm = carVehicle.getAverageFuelConsumption();
		System.out.println("Current consumption: " + carVehicle.getCurrentConsumption());
		System.out.println("Current number of km: " + carVehicle.getCurrentKm());
		System.out.println("Average fuel consumed is: " + fuelConsumedKm);

		pollutionKm = carVehicle.getPollution();
		System.out.println("Pollution is: " + pollutionKm);

	}

}
