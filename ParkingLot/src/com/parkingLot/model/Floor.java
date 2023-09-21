package com.parkingLot.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.parkingLot.constant.VehicleType;

public class Floor {
    private final Map<VehicleType, Queue<ParkingSpot>> availableParkingSpots;
    private final Map<VehicleType, Queue<ParkingSpot>> acquiredParkingSpots;

    public Floor() {
        this.availableParkingSpots = new HashMap<>();
        this.acquiredParkingSpots = new HashMap<>();

        for (VehicleType type : VehicleType.values()) {
            this.availableParkingSpots.put(type, new LinkedList<>());
            this.acquiredParkingSpots.put(type, new LinkedList<>());
        }
    }

    public void addAvailableSpot(ParkingSpot spot) {
        if (spot == null) {
            System.out.println("Error: Invalid parking spot.");
            return;
        }
        
        this.availableParkingSpots.get(spot.getVehicleType()).add(spot);
    }

    public void acquireSpot(ParkingSpot spot) {
        if (spot == null) {
            System.out.println("Error: Invalid parking spot.");
            return;
        }
        
        if (spot.isAvailable()) {
            this.availableParkingSpots.get(spot.getVehicleType()).remove(spot);
            this.acquiredParkingSpots.get(spot.getVehicleType()).add(spot);
            spot.setAvailable(false);
        }
    }
    
    public ParkingSpot getAvailableSpot(VehicleType type) {
        Queue<ParkingSpot> availableSpots = availableParkingSpots.get(type);

        if (!availableSpots.isEmpty()) {
            return availableSpots.peek();  // Peek instead of removing because we'll do that in acquireSpot.
        }
        
        return null;
    }

    public ParkingSpot findSpotByTicketId(int ticketId) {
        for (Queue<ParkingSpot> queue : acquiredParkingSpots.values()) {
            for (ParkingSpot spot : queue) {
                if (spot.getTicket().getId() == ticketId) {
                    return spot;
                }
            }
        }
        return null;
    }

    public void releaseSpot(ParkingSpot spot) {
        if (spot == null) {
            System.out.println("Error: Invalid parking spot.");
            return;
        }
        
        if (!spot.isAvailable()) {
            this.acquiredParkingSpots.get(spot.getVehicleType()).remove(spot);
            this.availableParkingSpots.get(spot.getVehicleType()).add(spot);
            spot.setAvailable(true);
        }
    }
}
