package com.parkingLot.client;

import com.parkingLot.model.Floor;
import com.parkingLot.model.ParkingSpot;

public class ExitGate {
    
    public static void releaseParkingSpot(Floor floor, int ticketId) {
        ParkingSpot spot = floor.findSpotByTicketId(ticketId);

        if (spot != null) {
            floor.releaseSpot(spot);
            System.out.println("Parking spot with ID: " + spot.getId() + " has been released.");
        } else {
            System.out.println("Invalid ticket ID! No matching parking spot found.");
        }
    }
}
