\# Day 5 — Inheritance, Polymorphism and Git Branching



\## 1. Objective



Learn abstract classes, interfaces, inheritance, method overloading, method overriding, runtime polymorphism, the Strategy pattern, and Git branching, merging, conflict resolution, and rebasing.



\## 2. Java Implementation



\- Created an abstract `Payment` class.

\- Implemented `CardPayment`, `UPIPayment`, and `CashPayment`.

\- Used the `Refundable` interface for card and UPI refunds.

\- Demonstrated method overloading with `pay()` and `pay(String reference)`.

\- Created the `HospitalStaff` hierarchy with `Doctor` and `Receptionist`.

\- Created `BaseEntity` and the `Patient` entity.

\- Implemented `PaymentStrategy` with standard and 10% discount strategies.



\## 3. Key Concepts



\- \*\*Inheritance:\*\* Child classes reuse and extend parent-class behaviour.

\- \*\*Abstraction:\*\* Abstract classes define common behaviour and methods for subclasses.

\- \*\*Interfaces:\*\* Define contracts implemented by classes.

\- \*\*Overloading:\*\* Methods share a name but have different parameter lists.

\- \*\*Overriding:\*\* Subclasses provide their own implementations of inherited methods.

\- \*\*Runtime polymorphism:\*\* A parent-class reference can invoke the implementation of the actual child object.

\- \*\*Strategy pattern:\*\* Payment calculations can be selected through the `PaymentStrategy` interface.



\## 4. Testing



Executed `mvn clean package` successfully and ran `app.Day5Application`. The output demonstrated the payment methods, refunds, hospital staff hierarchy, patient entity, and payment strategies.



\## 5. Git Practice



\- Created `feature/day-5-inheritance-polymorphism`.

\- Committed the Day 5 Java implementation.

\- Created conflicting versions of `merge-practice.txt` on `main` and the feature branch.

\- Resolved the conflict by retaining both payment methods.

\- Created a rebase practice commit and successfully rebased the feature branch onto `main`.



\## 6. Conclusion



Day 5 strengthened my understanding of object-oriented programming and practical Git collaboration workflows.

