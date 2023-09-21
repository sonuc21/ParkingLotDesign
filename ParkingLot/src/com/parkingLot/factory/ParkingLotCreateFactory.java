package com.parkingLot.factory;


import com.parkingLot.constant.VehicleType;
import com.parkingLot.model.FourWheelerParkingSpot;
import com.parkingLot.model.ParkingSpot;
import com.parkingLot.model.TwoWheelerParkingSpot;
import com.parkingLot.utility.InvalidChoiceException;

public class ParkingLotCreateFactory {
	
	public static ParkingSpot CreateParkingSpot(int id, VehicleType type) {
	    switch(type) {
	        case TWO_WHEELER:
	            return new TwoWheelerParkingSpot(id);
	        case FOUR_WHEELER:
	            return new FourWheelerParkingSpot(id);
	        default:
	            throw new InvalidChoiceException("Invalid choice for parking spot type.");
	    }
	}
}

