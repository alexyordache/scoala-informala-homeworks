package com.alex.carwash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alex.homework4.Car;
import com.alex.homework4.DummyCar;

public class CarInventory {

	private List<Car> cars;

	public CarInventory() {
		cars = new ArrayList<Car>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void removeCar(String chassisNumber) {
		cars.remove(new DummyCar(chassisNumber));
	}

	public List<Car> getMostFuelEfficientCars(int n) {
		Collections.sort(cars);
		return cars.subList(0, n);

	}

	public List<Car> getAllCars() {
		return cars; //need to return a list that a user can not modify (not cars).
	}
}
