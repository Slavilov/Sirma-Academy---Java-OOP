package items;

public class GroceryItem extends InventoryItem {
    public GroceryItem(String name, String category, double price, int quantity) {
        super(name, category, price, false, true, quantity);
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }
}