### Exercise 2: Search Function

**1. Asymptotic Notation**
big o is basically a way to explain how slow an algorithm gets as the input grows. it does not give exact time, it just shows the pattern, that is why it helps to compare algorithms without running them on huge data.

best case is when the item is the first one you check, so it is instant, O(1). average case is when the item is somewhere in the middle, so you check about half the list. worst case is when the item is at the end or not there at all, so you end up checking everything.

**4. Analysis**
linear search is O(N) as it checks items one by one, so more products means more time. binary search is O(log N) and it is way faster as it keeps cutting the list in half every time.

for an e commerce site with a lot of products, binary search is the better choice. you do need the data sorted first but that is fine since the speed is more useful when customers are searching.
