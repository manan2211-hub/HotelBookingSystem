/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 * Author: Manan Sharma
 */

import java.util.*;

// Reservation class


// Room Allocation Service
class RoomAllocationService {

    private Queue<Reservation> queue;
    private Map<String, Integer> inventory;
    private Set<String> allocatedRooms;
    private Map<String, Set<String>> roomMap;

    RoomAllocationService() {
        queue = new LinkedList<>();

        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);

        allocatedRooms = new HashSet<>();
        roomMap = new HashMap<>();
    }

    // Add booking request
    public void addRequest(Reservation r) {
        queue.add(r);
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {
        String roomId;
        do {
            roomId = roomType.substring(0, 1).toUpperCase() + (int)(Math.random() * 100);
        } while (allocatedRooms.contains(roomId)); // ensure uniqueness

        return roomId;
    }

    // Process booking
    public void processBookings() {

        while (!queue.isEmpty()) {
            Reservation r = queue.poll();

            String type = r.roomType;

            System.out.println("\nProcessing: " + r.guestName);

            if (inventory.getOrDefault(type, 0) > 0) {

                // Generate unique ID
                String roomId = generateRoomId(type);

                // Store in set (prevents duplicates)
                allocatedRooms.add(roomId);

                // Map room type to allocated rooms
                roomMap.putIfAbsent(type, new HashSet<>());
                roomMap.get(type).add(roomId);

                // Update inventory
                inventory.put(type, inventory.get(type) - 1);

                // Confirm booking
                System.out.println("Booking Confirmed!");
                System.out.println("Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed - No rooms available");
            }
        }
    }

    // Display final allocation
    public void displayAllocations() {
        System.out.println("\n=== Final Room Allocation ===");

        for (String type : roomMap.keySet()) {
            System.out.println(type + " Rooms: " + roomMap.get(type));
        }
    }
}

// Main class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        RoomAllocationService service = new RoomAllocationService();

        // Add requests (from UC5)
        service.addRequest(new Reservation("Manan", "Single"));
        service.addRequest(new Reservation("Rahul", "Double"));
        service.addRequest(new Reservation("Amit", "Single"));
        service.addRequest(new Reservation("Riya", "Suite"));
        service.addRequest(new Reservation("Karan", "Suite")); // should fail

        // Process bookings
        service.processBookings();

        // Show results
        service.displayAllocations();
    }
}
