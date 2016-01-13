package com.alex.carwash;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.alex.homework4.Car;

public class CarWash {
	private List<Car> waitingToBeWashedCars = new LinkedList<>();
	private Set<Car> todaysClients = new LinkedHashSet<>();
	private boolean opened = false;

	public void openShop() {
		this.opened = true;
		this.waitingToBeWashedCars.clear();
		this.todaysClients.clear();
		
	}

	public void closeShop() {
		this.opened = false;
	}

	public void standInLine(Car car) throws Exception {
		if (!this.opened) {
			throw new Exception("CarWash is closed!");
		}
		this.waitingToBeWashedCars.add(car);
		this.todaysClients.add(car);
	}

	public void washCar() throws Exception {
		if (!this.opened) {
			throw new Exception("CarWash is closed!");
		}
		if (this.waitingToBeWashedCars.isEmpty()) {
			throw new Exception("No cars in line - no cars to be washed");
		}
		System.out.println("Washing car " + this.waitingToBeWashedCars.get(0));
		this.waitingToBeWashedCars.remove(0);
	}

	public List<Car> getTodaysClients() {
		return new ArrayList<>(this.todaysClients);
	}

	public List<Car> getPostponedClients() {
		return new ArrayList<>(this.waitingToBeWashedCars);
	}
}
