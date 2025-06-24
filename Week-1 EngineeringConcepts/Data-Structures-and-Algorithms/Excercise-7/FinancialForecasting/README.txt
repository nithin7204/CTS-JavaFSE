Exercise 7: Financial Forecasting

Recursion simplifies problems where current output depends on prior output. In forecasting, it can model compound growth:
FV(n) = FV(n-1) * (1 + r)

Recursive Implementation:
- Base Case: n == 0 → return current value
- Recursive Case: call function for (n-1)

Time Complexity:
- Without memoization: O(n), but with redundant work
- With memoization: O(n), optimized by caching results

To optimize:
- Use memoization to avoid recomputing intermediate values.
- Alternatively, use iteration or dynamic programming.
