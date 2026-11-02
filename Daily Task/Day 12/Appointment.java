import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, LocalDate date, LocalTime time) {

        if (appointmentId <= 0)
            throw new IllegalArgumentException("Invalid appointment ID");

        if (patient == null || doctor == null)
            throw new IllegalArgumentException("Patient and doctor are required");

        if (date == null || date.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Invalid appointment date");

        if (time == null)
            throw new IllegalArgumentException("Appointment time is required");

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "\nAppointment ID: " + appointmentId
                + "\n" + patient
                + "\n" + doctor
                + "\nDate: " + date
                + "\nTime: " + time;
    }
}