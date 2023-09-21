package com.parkingLot.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.parkingLot.constant.VehicleType;
import com.parkingLot.model.Floor;

public class Client {

    public static void main(String[] args) {
        List<Floor> floors = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            displayMenu();
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    floors.add(new Floor());
                    System.out.println("New floor added!");
                    break;
                case 2:
                    if (floors.size() <= 0) {
                        System.out.println("Please add at least one floor.");
                        break;
                    }
                    System.out.println("Enter floor number where you want to add parking spot:");
                    int floorNumber = sc.nextInt() - 1; // assuming floor numbers start from 1, not 0
                    if (floorNumber < 0 || floorNumber >= floors.size()) {
                        System.out.println("Invalid floor number.");
                        break;
                    }
                    CreateFloor.addFloor(floors, floorNumber, sc);
                    break;
                case 3:
                    parkVehicle(floors, sc);
                    break;
                case 4:
                    System.out.println("Enter the ticket ID for the vehicle you want to release:");
                    int ticketId = sc.nextInt();
                    ExitGate.releaseParkingSpot(floors.get(0), ticketId);
                    break;
                case 5:
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    break;
            }
        }

        System.out.println("Thank you for using the parking lot system!");
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to add floor");
        System.out.println("Enter 2 to add Parking Spot");
        System.out.println("Enter 3 to park a Vehicle");
        System.out.println("Enter 4 if you want to release a parking spot");
        System.out.println("Enter 5 to exit");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }

    private static void parkVehicle(List<Floor> floors, Scanner sc) {
        System.out.println("Press 1 for Two Wheeler Spot");
        System.out.println("Press 2 for Four Wheeler Spot");
        int choice = sc.nextInt();
        VehicleType type = (choice == 1) ? VehicleType.TWO_WHEELER : VehicleType.FOUR_WHEELER;
        EntryGate.parkVehicle(floors.get(0), type);
    }
}
