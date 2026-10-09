package hospital.strategy;

public class StandardPaymentStrategy implements PaymentStrategy {

    @Override
    public double calculateAmount(double baseAmount) {
        if (baseAmount <= 0) {
            throw new IllegalArgumentException(
                    "Base amount must be greater than zero."
            );
        }

        return baseAmount;
    }

    @Override
    public String getStrategyName() {
        return "Standard Payment";
    }
}
