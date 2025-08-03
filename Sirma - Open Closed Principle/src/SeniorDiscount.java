public class SeniorDiscount implements Discount {
    public double apply(double price) {
        return price * 0.8;
    }
}
