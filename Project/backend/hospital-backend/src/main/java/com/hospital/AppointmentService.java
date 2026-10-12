
package com.hospital;

import com.hospital.exception.AppointmentConflictException;
import com.hospital.exception.InvalidAppointmentException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AppointmentService {

    // List: stores appointment records in booking order.
    private final List<String> appointments = new ArrayList<>();

    // Set: prevents the same slot from being booked twice.
    private final Set<String> bookedSlots = new HashSet<>();

    // Queue: maintains the OPD waiting line in FIFO order.
    private final Queue<String> opdQueue = new ArrayDeque<>();

    public void bookAppointment(String patientId, String slot) {

        if (patientId == null || patientId.isBlank()) {
            throw new InvalidAppointmentException(
                    "Patient ID cannot be empty."
            );
        }

        if (slot == null || slot.isBlank()) {
            throw new InvalidAppointmentException(
                    "Appointment slot cannot be empty."
            );
        }

        if (!bookedSlots.add(slot)) {
            throw new AppointmentConflictException(
                    "This appointment slot is already booked: " + slot
            );
        }

        String appointment = patientId + " - " + slot;

        appointments.add(appointment);
        opdQueue.offer(patientId);

        System.out.println(
                "Appointment booked successfully for patient "
                        + patientId + " at " + slot
        );
    }

    public List<String> getAppointments() {
        return new ArrayList<>(appointments);
    }

    public Set<String> getBookedSlots() {
        return new HashSet<>(bookedSlots);
    }

    public String callNextPatient() {
        return opdQueue.poll();
    }

    public Queue<String> getWaitingPatients() {
        return new ArrayDeque<>(opdQueue);
    }
}
