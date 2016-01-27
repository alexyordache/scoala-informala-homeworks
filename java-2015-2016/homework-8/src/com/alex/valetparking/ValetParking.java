package com.alex.valetparking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.alex.homework4.Vehicle;

public class ValetParking<T extends Vehicle> {

	private float distanceToSpot = 0.05f; // default distance

	private Map<Integer, ParkingTicket> parkingLotMap = new HashMap<>();

	private Map<ParkingTicket, T> parkedMap = new HashMap<>();

	public void generateParkingSpot(int numberOfLots) {

		for (int i = 1; i <= numberOfLots; i++) {
			parkingLotMap.put(i, null);
		}
	}

	private int getEmptyPlace() throws ParkingFullException {
		for (Entry<Integer, ParkingTicket> entry : parkingLotMap.entrySet()) {
			if (entry.getValue() == null) {
				return entry.getKey();
			}
		}
		throw new ParkingFullException("The parking is full");
	}
// TODO CODE REVIEW: Restrain yourself from committing code that is not used. If it is not used it has no added value. 
/*	public boolean isValetParkingFull() {
		for (Entry<Integer, ParkingTicket> entry : parkingLotMap.entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
		}
		return true;
	}*/

	public void parkVehicle(T t, ParkingTicket parkingTicket) throws ParkingFullException {
		// TODO CODE REVIEW: You are supposed to receive a ticket from the Vallet. Not the other way around.
		int spacePlace = getEmptyPlace();
		t.start();
		t.drive(distanceToSpot);
		t.stop();
		parkingLotMap.put(spacePlace, parkingTicket);
		parkedMap.put(parkingTicket, t);

	}

	public T retriveVehicle(ParkingTicket parkingTicket) throws ParkingSpaceNotFoundException, CarNotFoundException {
		boolean foundParkingPlaceForTicket = false;
		int parkingSpotNumber = 0;
		for (Entry<Integer, ParkingTicket> entry : parkingLotMap.entrySet()) {
			if (entry.getValue() == parkingTicket) {
				foundParkingPlaceForTicket = true;
				parkingSpotNumber = entry.getKey();
			}
		}
		if(!foundParkingPlaceForTicket){
			throw new ParkingSpaceNotFoundException("No parking space was found for the given ticket");
		}

		// TODO CODE REVIEW: Don't be shy. Use full names (vehicle instead of veh). There's enough memory to store the variable name, and it helps out when you read the code.
		T veh = null;
		for (Entry<ParkingTicket, T> entry : parkedMap.entrySet()) {
			if (entry.getKey() == parkingTicket) {
				veh = entry.getValue();
			}
		}
		if(veh == null) {
			throw new CarNotFoundException("Car was stolen!");
		}
		veh.start();
		veh.drive(distanceToSpot);
		veh.stop();
		freeParkingSpace(parkingTicket, parkingSpotNumber);
		return veh;
	}

	private void freeParkingSpace(ParkingTicket parkingTicket, int parkingSpotNumber) {
		parkingLotMap.put(parkingSpotNumber, null);
		parkedMap.remove(parkingTicket);
	}

	public ValetParking(int numberOfLots) {
		generateParkingSpot(numberOfLots);
	}
}
