# Day 10 — Memory Management

## Experiments
1. StackOverflowError using `-Xss256k`: Recursion depth was 3108.
2. OutOfMemoryError using `-Xmx64m`: Heap memory exhaustion was demonstrated.
3. String vs StringBuilder: String took 60 ms; StringBuilder took 1 ms in this run.
4. Integer Cache: `127 == 127` returned true; `128 == 128` returned false. `.equals()` returned true.
5. Garbage Collection: Used `-Xlog:gc` to observe Young GC and Full GC activity.

## Project Review
Reviewed memory management practices in the Hospital OPD project:
- Avoid unnecessary object creation.
- Avoid unlimited static collections.
- Close resources properly.
- Use StringBuilder for repeated string concatenation.
- Avoid exposing internal collections unnecessarily.

## Concepts Learned
- Stack and Heap memory
- Garbage Collection
- Young and Full GC
- Memory leaks and memory pitfalls
- Integer caching
- StringBuilder performance

## Result
All five memory experiments executed successfully.
