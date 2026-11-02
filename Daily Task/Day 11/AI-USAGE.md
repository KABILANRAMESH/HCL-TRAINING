# AI-USAGE.md

# AI Usage and Code Review — Day 11

## Entry 1: Student POJO

**AI Usage:** Generated a Student class using AI assistance.

**Review:** Checked encapsulation, constructor validation, getters, setters, equals(), hashCode(), and toString().

**Improvement:** Used private fields and input validation.

## Entry 2: Student Service

**AI Usage:** Generated student management operations.

**Review:** Checked null handling, duplicate students, collection access, and exception handling.

**Improvement:** Added null validation, duplicate checking, and defensive copying.

## Entry 3: Code Quality Review

**AI Usage:** Used AI to review Java OOP code.

**Review Issues Found:**
1. Public fields reduce encapsulation.
2. Returning internal collections exposes data.
3. Missing equals() and hashCode() can cause collection problems.
4. Missing null checks can cause NullPointerException.
5. Swallowed exceptions hide errors.

**Improvement:** Fixed these issues using encapsulation, defensive copies, proper equality methods, input validation, and meaningful exception handling.

## Conclusion

AI assistance helped generate Java boilerplate code. All generated code was reviewed and improved before use.
