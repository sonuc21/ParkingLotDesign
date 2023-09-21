package com.parkingLot.client;

import com.parkingLot.constant.VehicleType;
import com.parkingLot.model.Floor;
import com.parkingLot.model.ParkingSpot;
import com.parkingLot.model.Ticket;

public class EntryGate {

    public static void parkVehicle(Floor floor, VehicleType type) {
        ParkingSpot availableSpot = floor.getAvailableSpot(type);

        if (availableSpot != null) {
            floor.acquireSpot(availableSpot);
            Ticket tk = new Ticket(availableSpot);
            tk.printTicket();
        } else {
            System.out.println("Sorry, no available spots for " + type);
        }
    }
}
