import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatientService {

    private final Map<Integer, Patient> patients = new HashMap<>();

    // Register a new patient
    public void registerPatient(Patient patient) {

        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        int id = patient.getPatientId();

        if (patients.containsKey(id)) {
            throw new IllegalArgumentException("Patient ID already exists");
        }

        patients.put(id, patient);
        System.out.println("Patient registered successfully!");
    }

    // Search patient by ID
    public Patient searchPatient(int patientId) {

        Patient patient = patients.get(patientId);

        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }

        return patient;
    }

    // Display all patients
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    // Get total patient count
    public int getPatientCount() {
        return patients.size();
    }
}