public class DiscountCalculator {
    public double calculateDiscount(Discount discount, double price) {
        return discount.apply(price);
    }
}
