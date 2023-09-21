package com.parkingLot.model;

import com.parkingLot.constant.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot(int id) {
        super(id);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TWO_WHEELER;
    }
}

