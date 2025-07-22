import items.InventoryItem;
import order.Order;
import payment.Payment;
import utils.FileManager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<InventoryItem> inventory = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Item");
            System.out.println("2. List Items");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Is it breakable (true/false): ");
                    boolean breakable = scanner.nextBoolean();
                    System.out.print("Is it perishable (true/false): ");
                    boolean perishable = scanner.nextBoolean();
                    scanner.nextLine();

                    InventoryItem newItem = new InventoryItem(name, category, price, breakable, perishable, quantity);
                    inventory.add(newItem);
                    System.out.println("Item added.");
                    break;
                case 2:
                    for (InventoryItem item : inventory) {
                        item.displayDescription();
                        System.out.println("Quantity: " + item.getQuantity());
                    }
                    break;
                case 3:
                    FileManager.saveItems(inventory, "inventory.txt");
                    System.out.println("Items saved.");
                    break;
                case 4:
                    inventory = FileManager.loadItems("inventory.txt");
                    System.out.println("Items loaded.");
                    break;
                case 5:
                    Order order = new Order();
                    while (true) {
                        System.out.println("Enter item index to add to order or -1 to finish:");
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println(i + ": " + inventory.get(i).name + " (Qty: " + inventory.get(i).getQuantity() + ")");
                        }
                        int idx = scanner.nextInt();
                        if (idx == -1) break;

                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        if (qty <= inventory.get(idx).getQuantity()) {
                            order.addItem(inventory.get(idx), qty);
                        } else {
                            System.out.println("Not enough stock.");
                        }
                    }

                    double total = order.calculateTotal();
                    System.out.println("Total: $" + total);
                    Payment payment = new Payment(total);
                    if (payment.processPayment()) {
                        order.processOrder();
                        System.out.println("Order completed.");
                    }
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}