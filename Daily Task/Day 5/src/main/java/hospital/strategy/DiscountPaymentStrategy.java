package hospital.strategy;

public class DiscountPaymentStrategy implements PaymentStrategy {

    private static final double DISCOUNT_RATE = 0.10;

    @Override
    public double calculateAmount(double baseAmount) {
        if (baseAmount <= 0) {
            throw new IllegalArgumentException(
                    "Base amount must be greater than zero."
            );
        }

        return baseAmount * (1 - DISCOUNT_RATE);
    }

    @Override
    public String getStrategyName() {
        return "Discount Payment (10%)";
    }
}
