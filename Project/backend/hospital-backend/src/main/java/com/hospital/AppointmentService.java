package com.hospital;

import com.hospital.exception.AppointmentConflictException;
import com.hospital.exception.InvalidAppointmentException;

import java.util.HashSet;
import java.util.Set;

public class AppointmentService {

    private final Set<String> bookedSlots = new HashSet<>();

    public void bookAppointment(String patientId, String slot) {

        // Business Rule 1: Patient ID and slot must be valid.
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

        // Business Rule 2: A slot can only be booked once.
        if (!bookedSlots.add(slot)) {
            throw new AppointmentConflictException(
                    "This appointment slot is already booked: " + slot
            );
        }

        System.out.println(
                "Appointment booked successfully for patient "
                        + patientId + " at " + slot
        );
    }
}