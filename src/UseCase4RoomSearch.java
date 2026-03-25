/**
 * Use Case 4: Room Search & Availability Check
 */

import java.util.HashMap;

class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory) {

        System.out.println("=== Available Rooms ===");

        HashMap<String, Integer> rooms = inventory.getAllRooms();

        for (String type : rooms.keySet()) {

            int available = rooms.get(type);

            if (available > 0) {

                Room room;

                if (type.equals("Single Room")) {
                    room = new SingleRoom();
                } else if (type.equals("Double Room")) {
                    room = new DoubleRoom();
                } else {
                    room = new SuiteRoom();
                }

                room.displayDetails();
                System.out.println("Available: " + available);
            }
        }
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory);
    }
}