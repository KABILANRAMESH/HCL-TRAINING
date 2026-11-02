import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoctorService {

    private final Map<Integer, Doctor> doctors = new HashMap<>();

    public void addDoctor(Doctor doctor) {

        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");

        int id = doctor.getDoctorId();

        if (doctors.containsKey(id))
            throw new IllegalArgumentException("Doctor ID already exists");

        doctors.put(id, doctor);
        System.out.println("Doctor added successfully!");
    }

    public Doctor searchDoctor(int doctorId) {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }
}