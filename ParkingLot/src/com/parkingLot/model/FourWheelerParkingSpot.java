package com.parkingLot.model;

import com.parkingLot.constant.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(int id) {
        super(id);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.FOUR_WHEELER;
    }
}

