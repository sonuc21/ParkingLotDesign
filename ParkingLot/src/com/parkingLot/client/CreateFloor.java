package com.parkingLot.client;

import java.util.List;
import java.util.Scanner;

import com.parkingLot.constant.VehicleType;
import com.parkingLot.factory.ParkingLotCreateFactory;
import com.parkingLot.model.Floor;
import com.parkingLot.model.ParkingSpot;

public class CreateFloor {
    public static void addFloor(List<Floor> floors, int floorNumber, Scanner sc) {
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println("Press 1 to add Parking Spot");
            System.out.println("Enter 2 to exit");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Press 1 to add Two Wheeler Spot");
                    System.out.println("Press 2 to add Four Wheeler Spot");
                    int ch1 = sc.nextInt();
                    System.out.println("Enter id of the Parking Spot");
                    int id = sc.nextInt();
                    VehicleType type = (ch1 == 1) ? VehicleType.TWO_WHEELER : VehicleType.FOUR_WHEELER;
                    ParkingSpot spot = ParkingLotCreateFactory.CreateParkingSpot(id, type);
                    floors.get(floorNumber).addAvailableSpot(spot);
                    break;
                case 2:
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    break;
            }
        }
    }
}
