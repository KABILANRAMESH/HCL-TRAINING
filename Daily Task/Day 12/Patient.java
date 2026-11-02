
import java.util.Objects;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String phone;

    public Patient(int patientId, String name, int age, String phone) {

        if (patientId <= 0) {
            throw new IllegalArgumentException("Invalid patient ID");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name is required");
        }

        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Invalid patient age");
        }

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must contain 10 digits");
        }

        this.patientId = patientId;
        this.name = name.trim();
        this.age = age;
        this.phone = phone;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;

        Patient other = (Patient) obj;
        return patientId == other.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId
                + ", Name: " + name
                + ", Age: " + age
                + ", Phone: " + phone;
    }
}
