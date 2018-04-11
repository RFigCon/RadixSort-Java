# RadixSort-Java
My attempt at implementing Radix Sort in java.

*Currently neither file contains a MSD sort method.*

The **OldRadix.java** is the older *(and more readable)* version of **Radix.java**, **Radix.java** is an optimized version of **OldRadix.java**.

**Radix.java** was optimized by replacing the *'ArrayList< ArrayList<Integer> >'* with an int array, and also by replacing the *'isSorted'* check by a faster check. Now instead of iterating over the whole array to check is it's ordered, it just sees if the multiplier(*'mult'*) is bigger than the largest number, which is obtained at the start of the sort.
