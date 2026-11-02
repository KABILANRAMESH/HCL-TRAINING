
public class Consultation {
    private final int patientId;
    private final int doctorId;
    private final String diagnosis;
    private final String prescription;

    public Consultation(int patientId, int doctorId,
                        String diagnosis, String prescription) {
        if (patientId <= 0 || doctorId <= 0) {
            throw new IllegalArgumentException("Invalid patient or doctor ID");
        }
        if (diagnosis == null || diagnosis.isBlank()
                || prescription == null || prescription.isBlank()) {
            throw new IllegalArgumentException("Diagnosis and prescription are required");
        }

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    @Override
    public String toString() {
        return "Patient: " + patientId
                + ", Doctor: " + doctorId
                + ", Diagnosis: " + diagnosis
                + ", Prescription: " + prescription;
    }
}

