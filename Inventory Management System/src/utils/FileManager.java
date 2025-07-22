package utils;

import items.InventoryItem;

import java.io.*;
import java.util.*;

public class FileManager {
    public static void saveItems(List<InventoryItem> items, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (InventoryItem item : items) {
                writer.println(item.getId() + "," + item.name + "," + item.getCategory() + "," +
                               item.getPrice() + "," + item.getQuantity() + "," + item.isBreakable() + "," + item.isPerishable());
            }
        } catch (IOException e) {
            System.out.println("Error saving items: " + e.getMessage());
        }
    }

    public static List<InventoryItem> loadItems(String filename) {
        List<InventoryItem> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1];
                String category = parts[2];
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);
                boolean breakable = Boolean.parseBoolean(parts[5]);
                boolean perishable = Boolean.parseBoolean(parts[6]);

                InventoryItem item = new InventoryItem(name, category, price, breakable, perishable, quantity);
                items.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error loading items: " + e.getMessage());
        }
        return items;
    }
}