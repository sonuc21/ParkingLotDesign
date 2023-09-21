package com.parkingLot.model;

import com.parkingLot.constant.VehicleType;

public abstract class ParkingSpot {
    private int id;
    private boolean isAvailable;
    private Ticket ticket;

    public ParkingSpot(int id) {
        this.id = id;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public int getId() {
        return id;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public abstract VehicleType getVehicleType();
}
