/**
 * Use Case 7: Add-On Service Selection
 * Author: Manan Sharma
 */

import java.util.*;

// Add-On Service class
class Service {

    String name;
    int cost;

    Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    void display() {
        System.out.println(name + " - Cost: " + cost);
    }
}

// Service Manager
class AddOnServiceManager {

    private Map<String, List<Service>> serviceMap;

    AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, Service service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added " + service.name + " to " + reservationId);
    }

    // Display services for reservation
    public void displayServices(String reservationId) {

        System.out.println("\nServices for " + reservationId + ":");

        List<Service> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected");
            return;
        }

        for (Service s : services) {
            s.display();
        }
    }

    // Calculate total cost
    public int calculateTotalCost(String reservationId) {

        int total = 0;

        List<Service> services = serviceMap.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.cost;
            }
        }

        return total;
    }
}

// Main class
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        // Assume reservation IDs from UC6
        String r1 = "S101";
        String r2 = "D202";

        // Add services
        manager.addService(r1, new Service("WiFi", 200));
        manager.addService(r1, new Service("Breakfast", 300));
        manager.addService(r2, new Service("Spa", 500));

        // Display services
        manager.displayServices(r1);
        manager.displayServices(r2);

        // Total cost
        System.out.println("\nTotal cost for " + r1 + ": " + manager.calculateTotalCost(r1));
        System.out.println("Total cost for " + r2 + ": " + manager.calculateTotalCost(r2));
    }
}
