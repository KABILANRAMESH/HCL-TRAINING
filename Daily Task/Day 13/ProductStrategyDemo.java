
import java.util.*;
import java.util.function.*;

public class ProductStrategyDemo {

    static class Patient {
        private String name;
        private int age;
        private boolean active;

        Patient(String name, int age, boolean active) {
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isActive() {
            return active;
        }

        @Override
        public String toString() {
            return name + " | Age: " + age + " | Active: " + active;
        }
    }

    // Custom strategy interface
    @FunctionalInterface
    interface PatientStrategy {
        boolean check(Patient patient);
    }

    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient("Arun", 25, true),
                new Patient("Kabilan", 20, true),
                new Patient("Ravi", 45, false),
                new Patient("Priya", 30, true)
        );

        // Strategy 1: Check active patients
        PatientStrategy activeStrategy =
                patient -> patient.isActive();

        // Strategy 2: Check adult patients
        PatientStrategy adultStrategy =
                patient -> patient.getAge() >= 18;

        // Strategy 3: Check senior patients
        PatientStrategy seniorStrategy =
                patient -> patient.getAge() >= 40;

        System.out.println("=== ACTIVE PATIENTS ===");
        displayPatients(patients, activeStrategy);

        System.out.println("\n=== ADULT PATIENTS ===");
        displayPatients(patients, adultStrategy);

        System.out.println("\n=== SENIOR PATIENTS ===");
        displayPatients(patients, seniorStrategy);
    }

    static void displayPatients(
            List<Patient> patients,
            PatientStrategy strategy) {

        for (Patient patient : patients) {
            if (strategy.check(patient)) {
                System.out.println(patient);
            }
        }
    }
}
