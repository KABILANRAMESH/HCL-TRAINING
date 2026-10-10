# Day 6 - AI-Assisted Debugging Notes

## Stack Trace 1: IllegalStateException

### Stack Trace

```text
Exception in thread "main" java.lang.IllegalStateException: Requested quantity exceeds available stock
    at order.DebugDemo.main(DebugDemo.java:10)
```

### Copilot's Explanation

- **Exception type:** `java.lang.IllegalStateException`.
- **Likely cause:** The requested quantity is 15, but available stock is 10.
- **Source location:** `DebugDemo.java`, line 10, in `DebugDemo.main()`.
- **Suggested fix:** Request no more than the available stock, or update the stock value if more stock is genuinely available. A real application can catch the condition and report an out-of-stock response.
- **Evidence distinction:** The stack trace proves that an uncaught exception occurred and identifies the reported source location. The values of `quantity` and `stock`, and the condition that triggered the exception, are verified from the source code.

### My Verification

**Correct:** Copilot identified the exception type, source location, and likely cause correctly. I checked the source code and confirmed that `quantity = 15`, `stock = 10`, and `quantity > stock` is true.

**Incorrect:** No factual errors identified in this explanation.

**Conclusion:** I verified the AI explanation against the Java source code rather than accepting it without checking.

## Stack Trace 2: NumberFormatException

### Stack Trace

```text
Exception in thread "main" java.lang.NumberFormatException: For input string: "fifteen"
    at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
    at java.base/java.lang.Integer.parseInt(Integer.java:565)
    at java.base/java.lang.Integer.parseInt(Integer.java:662)
    at order.DebugDemo.main(DebugDemo.java:8)
```

### Copilot's Explanation

- **Exception type:** `NumberFormatException`, a subclass of `IllegalArgumentException`.
- **Meaning:** Java could not parse `"fifteen"` as an integer.
- **Root cause:** The string was passed to `Integer.parseInt()`.
- **Source location:** `DebugDemo.java`, line 8.
- **Stack trace interpretation:** The upper frames show Java library methods involved in parsing. The lower application frame identifies where the conversion was invoked.
- **Suggested fix:** Validate the input or catch `NumberFormatException` and provide a useful error message.

### My Verification

**Correct:** Copilot identified the exception, invalid numeric input, parsing method, and application source location correctly.

**Important distinction:** The trace confirms that parsing failed for `"fifteen"` and identifies the reported call site. Inspecting the code confirms how the value was supplied to `Integer.parseInt()`.

**Conclusion:** The AI explanation was consistent with the observed stack trace and source code. I verified both before accepting the recommendation.
