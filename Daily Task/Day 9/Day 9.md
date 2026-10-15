# Day 9 — Generics

## Topics Covered
- Generic classes: `Pair<K,V>` and `Box<T extends Number>`
- Bounded type parameters and `Comparable`
- Wildcards: `? extends` and `? super`
- Try-with-resources and `AutoCloseable`
- Reading CSV data using `BufferedReader`
- Generic repository using `CrudRepository<T, ID>`
- Reusable `InMemoryRepository<T, ID>`

## Implementation
Created `GenericToolkit.java` to demonstrate Java Generics, maximum-value comparison, wildcards, CSV reading, and automatic resource closing.

Created `CrudRepository.java` and `InMemoryRepository.java` to implement reusable save, find, and delete operations.

Created `RepositoryDemo.java` to test repository operations with sample patient data.

## Result
All programs compiled and ran successfully. Repository operations were verified using console output.

## Git
Branch: `day-9-generics`

Commit: `Complete Day 9 Generics`
