package com.parkingLot.model;

import java.time.LocalDateTime;

public class Ticket {
	private static int counter = 0;  // a static counter to generate unique IDs for tickets
	
	private int id;
	private LocalDateTime entryTime;
	private ParkingSpot parkingSpot;
	
	public Ticket(ParkingSpot parkingSpot) {
		this.id = ++counter;  // increment the counter to generate a new unique ID
		this.entryTime = LocalDateTime.now();  // set the entry time to the current time
		this.parkingSpot = parkingSpot;
	}
	
	public int getId() {
		return this.id;
	}
	
	public LocalDateTime getEntryTime() {
		return this.entryTime;
	}

	public ParkingSpot getParkingSpot() {
		return this.parkingSpot;
	}

	public void printTicket() {
		System.out.println("Ticket is printed with ID: " + this.id);
	}
}
