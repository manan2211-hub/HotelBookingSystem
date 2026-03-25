import java.util.*;

class BookingHistory {

    private List<Reservation> history;

    BookingHistory() {
        history = new ArrayList<>();
    }

    public void addReservation(Reservation r) {
        history.add(r);
        System.out.println("Added to history: " + r.reservationId);
    }

    public List<Reservation> getAllReservations() {
        return history;
    }
}

class ReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("\n===== Booking Report =====");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : reservations) {
            r.display();
        }
    }

    public void totalBookings(List<Reservation> reservations) {
        System.out.println("\nTotal Bookings: " + reservations.size());
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();
        ReportService report = new ReportService();

        // Use updated Reservation
        history.addReservation(new Reservation("R101", "Manan", "Single"));
        history.addReservation(new Reservation("R102", "Rahul", "Double"));
        history.addReservation(new Reservation("R103", "Amit", "Suite"));

        report.generateReport(history.getAllReservations());
        report.totalBookings(history.getAllReservations());
    }
}
