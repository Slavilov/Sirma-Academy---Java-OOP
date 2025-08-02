public class InvoiceRepository {
    public void saveInvoice(Invoice invoice) {
        System.out.println("Saving invoice for " + invoice.getCustomerName());
    }
}
