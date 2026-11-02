import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HospitalApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final PatientService patientService = new PatientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final AppointmentService appointmentService =
            new AppointmentService();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("==================================");
        System.out.println(" HOSPITAL OPD MANAGEMENT SYSTEM");
        System.out.println("==================================");

        while (running) {

            System.out.println("\n1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. View All Doctors");
            System.out.println("6. Book Appointment");
            System.out.println("7. View All Appointments");
            System.out.println("8. Cancel Appointment");
            System.out.println("9. Exit");

            try {
                System.out.print("\nEnter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        registerPatient();
                        break;

                    case 2:
                        viewPatients();
                        break;

                    case 3:
                        searchPatient();
                        break;

                    case 4:
                        addDoctor();
                        break;

                    case 5:
                        viewDoctors();
                        break;

                    case 6:
                        bookAppointment();
                        break;

                    case 7:
                        viewAppointments();
                        break;

                    case 8:
                        cancelAppointment();
                        break;

                    case 9:
                        running = false;
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void registerPatient() {

        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        Patient patient = new Patient(id, name, age, phone);

        patientService.registerPatient(patient);
    }

    private static void viewPatients() {

        if (patientService.getAllPatients().isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }

        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }
    }

    private static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(patientService.searchPatient(id));
    }

    private static void addDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization);

        doctorService.addDoctor(doctor);
    }

    private static void viewDoctors() {

        if (doctorService.getAllDoctors().isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor doctor : doctorService.getAllDoctors()) {
            System.out.println(doctor);
        }
    }

    private static void bookAppointment() {

        System.out.print("Enter Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());

        Patient patient = patientService.searchPatient(patientId);

        System.out.print("Enter Doctor ID: ");
        int doctorId = Integer.parseInt(scanner.nextLine());

        Doctor doctor = doctorService.searchDoctor(doctorId);

        System.out.print("Enter Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Time (HH:MM): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        appointmentService.bookAppointment(patient, doctor, date, time);
    }

    private static void viewAppointments() {

        if (appointmentService.getAllAppointments().isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        for (Appointment appointment : appointmentService.getAllAppointments()) {
            System.out.println(appointment);
        }
    }

    private static void cancelAppointment() {

        System.out.print("Enter Appointment ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        appointmentService.cancelAppointment(id);
    }
}