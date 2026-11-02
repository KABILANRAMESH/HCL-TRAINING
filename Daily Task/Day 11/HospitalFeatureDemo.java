
public class HospitalFeatureDemo {
    public static void main(String[] args) {

        // FR7: Doctor records consultation
        Consultation consultation = new Consultation(
                101, 201,
                "Fever",
                "Paracetamol"
        );

        System.out.println("=== FR7: Consultation ===");
        System.out.println(consultation);

        // FR8: Generate consultation bill
        Bill bill = new Bill(
                consultation.getPatientId(),
                500.00
        );

        System.out.println("\n=== FR8: Patient Bill ===");
        System.out.println(bill);
    }
}
