package order;

import items.InventoryItem;

import java.util.*;

public class Order {
    private List<InventoryItem> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    public void addItem(InventoryItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void processOrder() {
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            int quantity = quantities.get(i);
            item.setQuantity(item.getQuantity() - quantity);
        }
    }
}