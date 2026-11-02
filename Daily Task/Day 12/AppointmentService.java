import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {

    private final Map<Integer, Appointment> appointments = new HashMap<>();

    private int nextAppointmentId = 1;

    public void bookAppointment(Patient patient, Doctor doctor,
                                LocalDate date, LocalTime time) {

        for (Appointment appointment : appointments.values()) {

            boolean sameDoctor =
                    appointment.getDoctor().getDoctorId() == doctor.getDoctorId();

            boolean sameDate =
                    appointment.getDate().equals(date);

            boolean sameTime =
                    appointment.getTime().equals(time);

            if (sameDoctor && sameDate && sameTime) {
                throw new IllegalArgumentException(
                        "This doctor's time slot is already booked");
            }
        }

        Appointment appointment = new Appointment(
                nextAppointmentId++, patient, doctor, date, time);

        appointments.put(appointment.getAppointmentId(), appointment);

        System.out.println("Appointment booked successfully!");
        System.out.println(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments.values());
    }

    public void cancelAppointment(int appointmentId) {

        if (!appointments.containsKey(appointmentId))
            throw new IllegalArgumentException("Appointment not found");

        appointments.remove(appointmentId);

        System.out.println("Appointment cancelled successfully!");
    }

    public int getAppointmentCount() {
        return appointments.size();
    }
}