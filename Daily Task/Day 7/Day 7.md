## Hospital Project Integration

Updated the existing `AppointmentService` to use Java Collections Framework implementations.

- **List (`ArrayList`):** Stores appointment records in booking order.
- **Set (`HashSet`):** Prevents duplicate appointment slots.
- **Queue (`ArrayDeque`):** Maintains the OPD waiting line in FIFO order.
- **Defensive copies:** Getter methods return copies of internal collections.
- **Exception handling:** Invalid patient IDs and duplicate slots are rejected without terminating the demo.

### Verification Results

| Test | Result |
|---|---|
| Valid appointment booking | Passed |
| Empty patient ID rejected | Passed |
| Duplicate slot rejected | Passed |
| Appointment records displayed | Passed |
| Unique booked slots displayed | Passed |
| FIFO patient calling | Passed |
| Waiting queue emptied after calling | Passed |
| Hospital backend compilation | Passed |

The console demo verified the collection behavior. These results do not yet represent database-backed persistence or a full Spring Boot integration test.
