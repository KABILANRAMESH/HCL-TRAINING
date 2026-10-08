import java.util.Scanner;

public class HospitalOPDMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("\n===== HOSPITAL OPD & APPOINTMENT MANAGEMENT =====");
            System.out.println("1. Patient Registration");
            System.out.println("2. Doctor & Department Management");
            System.out.println("3. Doctor Schedule / Slots");
            System.out.println("4. Appointment Booking");
            System.out.println("5. Consultation & Prescription");
            System.out.println("6. Billing");
            System.out.println("7. Notifications");
            System.out.println("8. Reports");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Patient Registration selected.");
                    break;

                case 2:
                    System.out.println("Doctor & Department Management selected.");
                    break;

                case 3:
                    System.out.println("Doctor Schedule / Slots selected.");
                    break;

                case 4:
                    System.out.println("Appointment Booking selected.");
                    break;

                case 5:
                    System.out.println("Consultation & Prescription selected.");
                    break;

                case 6:
                    System.out.println("Billing selected.");
                    break;

                case 7:
                    System.out.println("Notifications selected.");
                    break;

                case 8:
                    System.out.println("Reports selected.");
                    break;

                case 9:
                    running = false;
                    System.out.println("Thank you for using Hospital OPD Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 9.");
            }

        } while (running);

        scanner.close();
    }
}