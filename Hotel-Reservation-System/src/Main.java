import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();
        system.loadData();

        while (true) {
            System.out.println("\n--- Welcome ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Mode");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> system.register(scanner);
                case 2 -> {
                    if (system.login(scanner)) {
                        userMenu(system, scanner);
                    }
                }
                case 3 -> system.adminMode(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void userMenu(ReservationSystem system, Scanner scanner) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Profile");
            System.out.println("2. View Rooms");
            System.out.println("3. Book a Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> system.viewProfile();
                case 2 -> system.viewRooms();
                case 3 -> system.bookRoom(scanner);
                case 4 -> system.cancelBooking(scanner);
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
