### Exercise 7: Financial Forecasting

**1. Recursion**
recursion is when a method calls itself to solve a smaller part of the same problem until it reaches a base case where it stops. it works well here as forecasting is just applying the same growth math every year, so recursion lets us write it once and let it keep going.

**4. Analysis**
the recursive method is O(N) as N is the number of years, since it makes one call per year.

to make it better we can use memoization, we save each years result once we calculate it, so if we need it again we just take it instead of calculating it again.
