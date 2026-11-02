import java.util.Objects;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;

    public Doctor(int doctorId, String name, String specialization) {

        if (doctorId <= 0)
            throw new IllegalArgumentException("Invalid doctor ID");

        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Doctor name is required");

        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization is required");

        this.doctorId = doctorId;
        this.name = name.trim();
        this.specialization = specialization.trim();
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Doctor)) return false;

        Doctor other = (Doctor) obj;
        return doctorId == other.doctorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId
                + ", Name: " + name
                + ", Specialization: " + specialization;
    }
}