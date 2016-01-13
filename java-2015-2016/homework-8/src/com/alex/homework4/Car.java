package com.alex.homework4;

public abstract class Car implements Vehicle, Comparable<Car> {

	private final float fuelTank;
	protected final String fuelType;
	protected final int numberOfGears;
	protected final float fuelConsumptionKm;
	private final float pollutionKm;

	private float availableFuel;
	private String chassisNumber;

	private float currentConsumption;
	private float pollution;

	private int currentGear;
	private float currentKm;

	Car(float availableFuel, String chassisNumber, float fuelTank, String fuelType, int numberOfGears,
			float fuelConsumptionKm, float pollutionKm) {
		this.availableFuel = availableFuel;
		this.setChassisNumber(chassisNumber);
		this.fuelTank = fuelTank;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.fuelConsumptionKm = fuelConsumptionKm;
		this.pollutionKm = pollutionKm;

		if (this.availableFuel > this.fuelTank) {
			System.out.println("Out of fuel!");
			System.exit(0);
		}
	}

	public float getFuelConsumptionKm() {
		return fuelConsumptionKm;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public float getAvailableFuel() {
		return availableFuel;
	}

	public void setAvailableFuel(float availableFuel) {
		this.availableFuel = availableFuel;
	}

	public float getCurrentConsumption() {
		return currentConsumption;
	}

	public void setCurrentConsumption(float currentConsumption) {
		this.currentConsumption = currentConsumption;
	}

	public float getPollution() {
		return pollution;
	}

	public void setPollution(float pollution) {
		this.pollution = pollution;
	}

	public int getCurrentGear() {
		return currentGear;
	}

	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}

	public float getCurrentKm() {
		return currentKm;
	}

	public void setCurrentKm(float currentKm) {
		this.currentKm = currentKm;
	}

	private void updateAvailableFuelAmount() {
		float fuel = this.availableFuel - this.getCurrentConsumption();
		this.setAvailableFuel(fuel);
	}

	public void start() {
		this.setCurrentConsumption(0);
		this.setPollution(0);
		this.setCurrentKm(0);
	}

	public void shiftGear(int gear) {
		this.currentGear = gear;
	}

	public void stop() {
		updateAvailableFuelAmount();
		this.setPollution(pollutionKm);
	}

	public void drive(float numberKm) {
		float consumption = this.getCurrentConsumption() + calculateConsumption(numberKm, this.getCurrentGear());
		this.setCurrentConsumption(consumption);
		float km = this.getCurrentKm() + numberKm;
		this.setCurrentKm(km);
	}

	public float getAverageFuelConsumption() {
		float averageFuelConsumption = this.getCurrentConsumption() / this.getCurrentKm() * 100;
		return averageFuelConsumption;
	}

	abstract float calculateConsumption(float kmNumber, int gear);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Car other = (Car) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		return true;
	}

	@Override
	public int compareTo(Car car) {
		if (this.fuelConsumptionKm < car.getFuelConsumptionKm()) {
			return -1;
		}
		if (this.fuelConsumptionKm > car.getFuelConsumptionKm()) {
			return 1;
		}
		return 0;
	}

}