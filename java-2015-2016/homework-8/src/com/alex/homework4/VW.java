package com.alex.homework4;

public abstract class VW extends Car {

	private static final String BRAND = "Volkswagen";

	VW(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionKm, float pollutionPerKm) {
		super(availableFuel, chassisNumber, fuelTank, fuelType, numberOfGears, fuelConsumptionKm, pollutionPerKm);
	}

	abstract float calculateConsumption(float kilometersNumber, int gear);

	public static String getBrand() {
		return BRAND;
	}
}
