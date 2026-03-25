/**
 * Use Case 2: Basic Room Types & Static Availability
 * Author: Manan Sharma
 * Version: 2.0
 */

abstract class Room {

    String roomType;
    int price;

    Room(String roomType, int price) {
        this.roomType = roomType;
        this.price = price;
    }

    abstract void displayDetails();
}

// Single Room
class SingleRoom extends Room {

    SingleRoom() {
        super("Single Room", 1000);
    }

    void displayDetails() {
        System.out.println(roomType + " - Price: " + price);
    }
}

// Double Room
class DoubleRoom extends Room {

    DoubleRoom() {
        super("Double Room", 2000);
    }

    void displayDetails() {
        System.out.println(roomType + " - Price: " + price);
    }
}

// Suite Room
class SuiteRoom extends Room {

    SuiteRoom() {
        super("Suite Room", 5000);
    }

    void displayDetails() {
        System.out.println(roomType + " - Price: " + price);
    }
}

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=== Room Details ===");

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        r1.displayDetails();
        System.out.println("Available: " + singleAvailable);

        r2.displayDetails();
        System.out.println("Available: " + doubleAvailable);

        r3.displayDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}
