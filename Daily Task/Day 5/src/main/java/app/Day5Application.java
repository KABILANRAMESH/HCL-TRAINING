package app;

import payment.*;
import hospital.model.*;
import hospital.strategy.*;

public class Day5Application {

    public static void main(String[] args) {

        System.out.println("===== DAY 5: INHERITANCE & POLYMORPHISM =====");

        // 1. Runtime polymorphism
        System.out.println("\n===== PAYMENT METHODS =====");

        Payment[] payments = {
                new CardPayment(2000, "Kabilan"),
                new UPIPayment(1500, "kabilan@upi"),
                new CashPayment(500)
        };

        for (Payment payment : payments) {
            payment.pay();
            System.out.println();
        }

        // 2. Method overloading
        System.out.println("===== METHOD OVERLOADING =====");

        Payment card = new CardPayment(2000, "Kabilan");
        card.pay("TXN-CARD-101");

        // 3. Interface-based refunds
        System.out.println("\n===== REFUNDS =====");

        Refundable cardRefund = new CardPayment(2000, "Kabilan");
        cardRefund.refund(500);

        Refundable upiRefund = new UPIPayment(1500, "kabilan@upi");
        upiRefund.refund(300);

        // 4. Hospital staff hierarchy
        System.out.println("\n===== HOSPITAL STAFF =====");

        HospitalStaff[] staff = {
                new Doctor(101, "Dr. Kumar", "Cardiology"),
                new Receptionist(102, "Priya")
        };

        for (HospitalStaff member : staff) {
            member.displayDetails();
            System.out.println();
        }

        // 5. BaseEntity and Patient
        System.out.println("===== PATIENT ENTITY =====");

        Patient patient = new Patient(201, "Arun", 25);
        System.out.println(patient);
        System.out.println("Entity type: " + patient.getEntityType());

        // 6. Strategy pattern
        System.out.println("\n===== PAYMENT STRATEGIES =====");

        PaymentStrategy[] strategies = {
                new StandardPaymentStrategy(),
                new DiscountPaymentStrategy()
        };

        double baseAmount = 1000;

        for (PaymentStrategy strategy : strategies) {
            System.out.println("Strategy: " + strategy.getStrategyName());
            System.out.println(
                    "Final amount: ₹" +
                    strategy.calculateAmount(baseAmount)
            );
            System.out.println();
        }

        System.out.println("===== DAY 5 COMPLETED =====");
    }
}
