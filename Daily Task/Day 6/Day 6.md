\# Day 6 — Exception Handling + AI-Assisted Debugging



\## 1. Objectives

\- Understand checked and unchecked exceptions.

\- Learn `try`, `catch`, `finally`, `throw`, and `throws`.

\- Create custom exceptions for business rules.

\- Use AI assistance to interpret Java stack traces and verify the explanation.



\## 2. Order Processing

Implemented an order processor with custom `InsufficientStockException` and `InvalidQuantityException` classes.



Features:

\- Rejects quantities that are zero or negative.

\- Rejects orders exceeding available stock.

\- Preserves the original cause of a stock exception.

\- Uses multi-catch, `finally`, and exception handling in the main loop.

\- Continues processing after a failed order.



\## 3. Hospital Appointment Business Rules

Added the `com.hospital.exception` package with:

\- `InvalidAppointmentException`

\- `AppointmentConflictException`



Created `AppointmentService` and `AppointmentServiceDemo` to demonstrate:

1\. Patient ID and appointment slot must not be empty.

2\. An appointment slot cannot be booked twice.



The demo successfully booked a valid appointment, rejected an empty patient ID, rejected a duplicate slot, and continued execution.



\## 4. AI-Assisted Debugging

Used GitHub Copilot Chat to examine two Java stack traces:

\- `IllegalStateException`: requested quantity exceeded available stock.

\- `NumberFormatException`: the string `"fifteen"` could not be converted to an integer.



Compared the AI explanations with the exception messages, stack frames, and source code lines. The explanations correctly identified the causes and relevant locations.



See `AI-Debugging-Notes.md` for the recorded analysis.



\## 5. Verification

\- Order processor demo executed successfully.

\- Appointment demo executed successfully.

\- Hospital backend compiled and packaged successfully using `mvn -DskipTests package`.

\- The regular `mvn package` test phase exposed an existing Spring Boot test configuration issue: no database URL or embedded database was configured.



\## 6. Key Learnings

\- Checked exceptions must be handled or declared.

\- Unchecked exceptions extend `RuntimeException`.

\- `throw` raises an exception; `throws` declares possible exceptions.

\- `finally` runs during normal and exceptional control flow in these examples.

\- Exception chaining preserves the original cause.

\- AI-generated debugging explanations must be verified against the actual stack trace and code.



\## 7. Limitations

The appointment demonstration uses an in-memory set. It does not persist appointments or check doctor-specific schedules in a database.

