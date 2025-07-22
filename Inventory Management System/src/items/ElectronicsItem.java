package items;

public class ElectronicsItem extends InventoryItem {
    public ElectronicsItem(String name, String category, double price, int quantity) {
        super(name, category, price, false, false, quantity);
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity() * 1.1; // 10% markup
    }
}