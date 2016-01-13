package com.alex.homework4;

public abstract class Dacia extends Car {

	private static final String BRAND = "Dacia";

	Dacia(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionPerHundredKm, float pollutionPerKm) {
		super(availableFuel, chassisNumber, fuelTank, fuelType, numberOfGears, fuelConsumptionPerHundredKm,
				pollutionPerKm);
	}

	abstract float calculateConsumption(float kilometersNumber, int gear);

	public static String getBrand() {
		return BRAND;
	}
}
