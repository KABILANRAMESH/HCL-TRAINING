
public class Bill {
    private final int patientId;
    private final double consultationFee;

    public Bill(int patientId, double consultationFee) {
        if (patientId <= 0 || consultationFee < 0) {
            throw new IllegalArgumentException("Invalid bill details");
        }

        this.patientId = patientId;
        this.consultationFee = consultationFee;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId
                + ", Consultation Fee: Rs. " + consultationFee;
    }
}
