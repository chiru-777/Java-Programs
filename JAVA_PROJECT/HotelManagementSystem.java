import java.util.*;

public class HotelManagementSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Luxury"));
    
        while (true) {
            System.out.println("\n--- HOTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: viewRooms(); break;
                case 2: bookRoom(); break;
                case 3: cancelBooking(); break;
                case 4: viewBookings(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void viewRooms() {
        for (Room r : rooms) {
            System.out.println("Room No: " + r.roomNumber +
                    " | Type: " + r.type +
                    " | Status: " + (r.isBooked ? "Booked" : "Available"));
        }
    }

    static void bookRoom() {
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room r : rooms) {
            if (r.roomNumber == roomNo && !r.isBooked) {
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                r.isBooked = true;
                bookings.add(new Booking(roomNo, name));

                System.out.println("Room booked!");
                return;
            }
        }
        System.out.println("Room not available!");
    }

    static void cancelBooking() {
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.roomNumber == roomNo) {
                it.remove();

                for (Room r : rooms) {
                    if (r.roomNumber == roomNo) {
                        r.isBooked = false;
                    }
                }

                System.out.println("Booking cancelled!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings!");
            return;
        }

        for (Booking b : bookings) {
            System.out.println("Room No: " + b.roomNumber +
                    " | Customer: " + b.customerName);
        }
    }
}