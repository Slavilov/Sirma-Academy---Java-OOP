public class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Printing invoice for " + invoice.getCustomerName() + ", amount: " + invoice.getAmount());
    }
}
