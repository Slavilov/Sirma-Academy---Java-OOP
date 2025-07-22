package payment;

public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean processPayment() {
        System.out.println("Processing payment of $" + amount + "...");
        return true; // Assume success
    }
}