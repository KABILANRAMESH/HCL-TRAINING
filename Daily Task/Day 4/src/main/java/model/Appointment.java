package model;

import java.time.LocalDate;
import java.util.Objects;

public class Appointment {

    private final int appointmentId;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDate appointmentDate;
    private String status;

    public Appointment(
            int appointmentId,
            Patient patient,
            Doctor doctor,
            LocalDate appointmentDate,
            String status) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = status;
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

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment appointment)) return false;
        return appointmentId == appointment.appointmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                ", appointmentDate=" + appointmentDate +
                ", status='" + status + '\'' +
                '}';
    }
}