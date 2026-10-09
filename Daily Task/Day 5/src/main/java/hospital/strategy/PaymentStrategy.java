package hospital.strategy;

public interface PaymentStrategy {

    double calculateAmount(double baseAmount);

    String getStrategyName();
}
