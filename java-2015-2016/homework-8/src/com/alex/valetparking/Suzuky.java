package com.alex.valetparking;

public class Suzuky extends Motorcycle {

	Suzuky(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionKm, float pollutionKm) {
		super(availableFuel, chassisNumber, fuelTank, fuelType, numberOfGears, fuelConsumptionKm, pollutionKm);
		// TODO Auto-generated constructor stub
	}

	@Override
	float calculateConsumption(float kmNumber, int gear) {
		// TODO Auto-generated method stub
		return 0;
	}

}
