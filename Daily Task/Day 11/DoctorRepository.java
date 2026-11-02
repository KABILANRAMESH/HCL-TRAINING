
import java.util.HashMap;
import java.util.Map;

public class DoctorRepository {
    private final Map<Integer, Doctor> doctors = new HashMap<>();

    public Doctor save(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        doctors.put(doctor.getDoctorId(), doctor);
        return doctor;
    }

    public Doctor findById(int id) {
        return doctors.get(id);
    }

    public boolean deleteById(int id) {
        return doctors.remove(id) != null;
    }

    public int count() {
        return doctors.size();
    }
}
