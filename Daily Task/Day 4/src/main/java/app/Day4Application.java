package app;

import model.Appointment;
import model.BankAccount;
import model.Doctor;
import model.Patient;
import service.BankAccountService;

import java.time.LocalDate;

public class Day4Application {

    public static void main(String[] args) {

        System.out.println("===== DAY 4 OOP DEMONSTRATION =====");

        // Constructor chaining
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("Kabilan");
        BankAccount account3 = new BankAccount("Hospital Admin", 10000.00);

        System.out.println("\n===== BANK ACCOUNTS =====");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        System.out.println("\nTotal accounts created: "
                + BankAccount.getAccountCounter());

        // Deposit
        account3.deposit(5000);

        System.out.println("\nAfter deposit:");
        System.out.println(account3);

        // Service layer
        BankAccountService service = new BankAccountService();

        System.out.println("\n===== WITHDRAWAL DEBUGGING =====");

        service.performWithdrawal(account3, 2000);

        // Hospital entities
        Patient patient = new Patient(
                101,
                "Arun",
                25,
                "9876543210"
        );

        Doctor doctor = new Doctor(
                201,
                "Dr. Kumar",
                "Cardiology",
                "Cardiology"
        );

        Appointment appointment = new Appointment(
                301,
                patient,
                doctor,
                LocalDate.now(),
                "BOOKED"
        );

        System.out.println("\n===== HOSPITAL ENTITIES =====");
        System.out.println(patient);
        System.out.println(doctor);
        System.out.println(appointment);

        System.out.println("\n===== OOP CONCEPTS =====");
        System.out.println("Encapsulation: private fields");
        System.out.println("Constructor chaining: this()");
        System.out.println("Static: accountCounter");
        System.out.println("Instance: accountHolder and balance");
        System.out.println("Packages: model, service, app");
        System.out.println("Access modifiers: private, public");
        System.out.println("equals/hashCode implemented.");
    }
}