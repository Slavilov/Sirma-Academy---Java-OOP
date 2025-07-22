package items;

public class FragileItem extends InventoryItem {
    public FragileItem(String name, String category, double price, int quantity) {
        super(name, category, price, true, false, quantity);
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity() * 0.95; // 5% chance of loss
    }
}