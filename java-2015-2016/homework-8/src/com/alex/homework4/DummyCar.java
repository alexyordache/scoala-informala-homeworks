package com.alex.homework4;

public class DummyCar extends Car {
	
	public DummyCar(String chassisNumber) {
		super(0, chassisNumber, 0, "", 0, 0, 0);
	}

	@Override
	float calculateConsumption(float kmNumber, int gear) {
		return 0;
	}
	
}
