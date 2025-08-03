public class StudentDiscount implements Discount {
    public double apply(double price) {
        return price * 0.9;
    }
}
