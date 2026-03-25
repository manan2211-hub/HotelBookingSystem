/**
 * Use Case 5: Booking Request Queue (FIFO)
 * Author: Manan Sharma
 * Version: 5.0
 */

import java.util.LinkedList;
import java.util.Queue;

// Reservation class (Represents a booking request)
class Reservation {

    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room: " + roomType);
    }
}

// Booking Queue Service
class BookingRequestQueue {

    private Queue<Reservation> queue;

    BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added for " + reservation.guestName);
    }

    // Process next request (FIFO)
    public Reservation processRequest() {
        if (queue.isEmpty()) {
            System.out.println("No pending requests");
            return null;
        }

        return queue.poll(); // FIFO removal
    }

    // Display all requests
    public void displayQueue() {
        System.out.println("\n=== Booking Queue ===");

        for (Reservation r : queue) {
            r.display();
        }
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("R101", "Manan", "Single Room"));
        bookingQueue.addRequest(new Reservation("R102", "Rahul", "Double Room"));
        bookingQueue.addRequest(new Reservation("R103", "Amit", "Suite Room"));
        // Show queue
        bookingQueue.displayQueue();

        // Process requests (FIFO)
        System.out.println("\nProcessing Request...");
        Reservation processed = bookingQueue.processRequest();

        if (processed != null) {
            System.out.println("Processed:");
            processed.display();
        }

        // Show remaining queue
        bookingQueue.displayQueue();
    }
}
