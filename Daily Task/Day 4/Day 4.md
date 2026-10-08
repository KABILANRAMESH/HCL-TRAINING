\# Day 4 - OOP Concepts + IDE \& Debugging



\## Topics Covered



\- Classes, fields and methods

\- Constructors

\- Constructor overloading

\- Constructor chaining using `this()`

\- `this` keyword

\- Encapsulation

\- Static and instance members

\- Access modifiers

\- Packages

\- `equals()` and `hashCode()`

\- IDE debugging

\- Breakpoints

\- Conditional breakpoints

\- Watch variables

\- Call stack

\- Step Over

\- Hot Code Replace



\## BankAccount



Created a `BankAccount` class with:



\- Private fields

\- Static account counter

\- Three chained constructors

\- Validated deposit

\- Validated withdrawal

\- `equals()`

\- `hashCode()`

\- `toString()`



\## Hospital Model Classes



Created three main hospital entities:



\- Patient

\- Doctor

\- Appointment



\## Packages



\### model

Contains:



\- BankAccount

\- Patient

\- Doctor

\- Appointment



\### service

Contains:



\- BankAccountService



\### app

Contains:



\- Day4Application



\## Debugging



An intentional bug was added to the `withdraw()` method.



The incorrect code was:



```java

balance += amount;

