package items;

import abstracts.AbstractItem;

import java.util.UUID;

public class InventoryItem extends AbstractItem {
    private String id;
    private int quantity;

    public InventoryItem(String name, String category, double price, boolean breakable, boolean perishable, int quantity) {
        super(name, category, price, breakable, perishable);
        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateValue() {
        return price * quantity;
    }
}