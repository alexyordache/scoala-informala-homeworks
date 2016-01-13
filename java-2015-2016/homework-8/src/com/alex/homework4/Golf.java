package com.alex.homework4;

public class Golf extends VW {

	private final static float FUEL_TANK_SIZE = 55;
	private final static String FUEL_TYPE = "DIESEL";
	private final static int NUMBER_OF_GEARS = 5;
	private final static float CONSUMPTION_KM = 6;
	private final static float POLLUTION_KM = 113;

	public Golf(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber, FUEL_TANK_SIZE, FUEL_TYPE, NUMBER_OF_GEARS, CONSUMPTION_KM, POLLUTION_KM);
	}

	float calculateFuelKm(int gear) {
		float fuelValue;
		switch (gear) {
		case 1:
			fuelValue = 12f;
			break;
		case 2:
			fuelValue = 7.5f;
			break;
		case 3:
			fuelValue = 5.5f;
			break;
		case 4:
			fuelValue = 4f;
			break;
		case 5:
			fuelValue = 3.5f;
			break;
		default:
			fuelValue = 1;
			break;
		}
		return fuelValue;
	}

	public float calculateConsumption(float kilometersNumber, int gear) {
		if (gear != 0) {
			float consumption = calculateFuelKm(this.getCurrentGear()) * kilometersNumber / 100;
			return consumption;
		} else
			return (CONSUMPTION_KM * kilometersNumber);
	}

}
