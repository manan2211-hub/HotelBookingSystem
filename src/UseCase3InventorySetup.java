/**
 * Use Case 3: Centralized Room Inventory Management
 * Author: Manan Sharma
 * Version: 3.0
 */

import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    RoomInventory() {
        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }
    public HashMap<String, Integer> getAllRooms() {
        return inventory;
    }


    // Display all rooms
    public void displayInventory() {
        System.out.println("=== Current Room Inventory ===");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " : " + inventory.get(roomType));
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Example: Update after booking
        System.out.println("\nBooking 1 Single Room...");

        int current = inventory.getAvailability("Single Room");
        inventory.updateAvailability("Single Room", current - 1);

        // Display updated inventory
        inventory.displayInventory();
    }
}
