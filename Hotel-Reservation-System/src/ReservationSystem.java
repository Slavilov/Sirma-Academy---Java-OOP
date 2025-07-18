import java.io.*;
import java.util.*;

public class ReservationSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private User currentUser = null;

    private final String ROOM_FILE = "rooms.txt";
    private final String USER_FILE = "users.txt";
    private final String ADMIN_PASSWORD = "admin123";

    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROOM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                rooms.add(Room.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("No rooms loaded.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("No users loaded.");
        }
    }

    public void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ROOM_FILE))) {
            for (Room room : rooms) {
                pw.println(room.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving room data.");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                pw.println(user.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    public void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.add(new User(username, password));
        saveData();
        System.out.println("Registration successful.");
    }

    public boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Login failed.");
        return false;
    }

    public void viewProfile() {
        if (currentUser == null) return;
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Booking History:");
        for (String entry : currentUser.getBookingHistory()) {
            System.out.println(" - " + entry);
        }
    }

    public void viewRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void bookRoom(Scanner scanner) {
        System.out.print("Enter room number to book: ");
        String number = scanner.nextLine();
        for (Room room : rooms) {
            if (room.getNumber().equals(number)) {
                if (room.isBooked()) {
                    System.out.println("Room already booked.");
                } else {
                    room.setBooked(true);
                    String booking = "Booked Room " + number + " for $" + room.getPrice();
                    currentUser.addBooking(booking);
                    saveData();
                    System.out.println("Booking successful.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public void cancelBooking(Scanner scanner) {
        System.out.print("Enter room number to cancel: ");
        String number = scanner.nextLine();
        for (Room room : rooms) {
            if (room.getNumber().equals(number)) {
                if (!room.isBooked()) {
                    System.out.println("Room is not booked.");
                } else {
                    room.setBooked(false);
                    String cancellation = "Cancelled Room " + number + ". Fee: $" + room.getCancellationFee();
                    currentUser.addBooking(cancellation);
                    saveData();
                    System.out.println("Booking canceled. Fee applied.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public void adminMode(Scanner scanner) {
        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine();
        if (!pass.equals(ADMIN_PASSWORD)) {
            System.out.println("Incorrect admin password.");
            return;
        }

        while (true) {
            System.out.println("\n--- Admin Mode ---");
            System.out.println("1. View All Bookings");
            System.out.println("2. View Income");
            System.out.println("3. Exit Admin Mode");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    for (User user : users) {
                        System.out.println("User: " + user.getUsername());
                        for (String b : user.getBookingHistory()) {
                            System.out.println("  - " + b);
                        }
                    }
                }
                case "2" -> {
                    double income = 0;
                    double cancelFees = 0;
                    for (Room room : rooms) {
                        if (room.isBooked()) income += room.getPrice();
                    }
                    for (User user : users) {
                        for (String h : user.getBookingHistory()) {
                            if (h.startsWith("Cancelled")) {
                                String[] parts = h.split("\$");
                                cancelFees += Double.parseDouble(parts[1]);
                            }
                        }
                    }
                    System.out.println("Total Income from Bookings: $" + income);
                    System.out.println("Total Cancellation Fees: $" + cancelFees);
                }
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
