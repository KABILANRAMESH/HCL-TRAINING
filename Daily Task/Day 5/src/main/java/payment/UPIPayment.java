package payment;

public class UPIPayment extends Payment implements Refundable {

    private final String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing UPI payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount paid: ₹" + amount);
        System.out.println("UPI payment successful!");
    }

    @Override
    public void refund(double refundAmount) {
        if (refundAmount <= 0 || refundAmount > amount) {
            throw new IllegalArgumentException("Invalid refund amount.");
        }

        System.out.println("UPI refund processed: ₹" + refundAmount);
    }
}
