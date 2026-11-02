# Day 13 – Functional Programming

## Learning Objectives
- Lambda expressions
- Functional interfaces
- Predicate, Function, Consumer and Supplier
- Predicate composition: and(), or(), negate()
- Function composition: andThen(), compose()
- Method references
- Custom @FunctionalInterface
- Effectively-final variable capture

## Practical Exercise 1: Product Filter Engine

**File:** FilterEngine.java

Implemented:
- Product filtering using composed Predicates
- Product transformation using Function
- Product printing using Consumer
- Default product creation using Supplier
- Custom ProductValidator interface
- Four types of method references
- Effectively-final variable capture

## Practical Exercise 2: Patient Strategy Demo

**File:** ProductStrategyDemo.java

Implemented:
- Active patient filtering
- Adult patient filtering
- Senior patient filtering
- Custom PatientStrategy functional interface
- Lambda-based strategy implementations

## Concepts Practised
1. Lambda expressions
2. Functional interfaces
3. Stream API
4. Predicate composition
5. Function composition
6. Method references
7. Strategy pattern using lambdas

## Assessment
- FilterEngine.java: Successfully compiled and executed.
- ProductStrategyDemo.java: Verify execution.
- No anonymous inner classes used where a lambda is suitable.

## Git Branch
day-13-functional-programming