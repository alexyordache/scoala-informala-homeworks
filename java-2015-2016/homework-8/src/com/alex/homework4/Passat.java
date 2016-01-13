package com.alex.homework4;

public class Passat extends VW {

	private final static float FUEL_TANK_SIZE = 70;
	private final static String FUEL_TYPE = "DIESEL";
	private final static int NUMBER_OF_GEARS = 6;
	private final static float CONSUMPTION_KM = 5.9f;
	private final static float POLLUTION_KM = 177;

	public Passat(float availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber, FUEL_TANK_SIZE, FUEL_TYPE, NUMBER_OF_GEARS, CONSUMPTION_KM, POLLUTION_KM);
	}

	float calculateFuelKm(int gear) {

		float fuelValue;
		switch (gear) {
		case 1:
			fuelValue = 12f;
			break;
		case 2:
			fuelValue = 8;
			break;
		case 3:
			fuelValue = 6.5f;
			break;
		case 4:
			fuelValue = 6;
			break;
		case 5:
			fuelValue = 5;
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
