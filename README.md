# RadixSort-Java
My attempt at implementing Radix Sort in java.

*Currently neither file contains a MSD sort method.*

The **OldRadix.java** is the older *(and more readable)* version of **Radix.java**, **Radix.java** is an optimized version of **OldRadix.java**.

**Radix.java** was optimized by replacing the *'ArrayList< ArrayList<Integer> >'* with an int array, and also by replacing the *'isSorted'* check by a faster check.
Now instead of iterating over the whole array to check is it's ordered, it just sees if the multiplier(*'mult'*) is bigger than the largest number, which is obtained at the start of the sort.
However, in some cases it will perform more iterations than than if *'isSorted'* was used, because it does not know for sure
that the array is sorted until it has iterated over every digit of the largest number in the array.

In theory, the largest number method should be faster on large arrays where all numbers have about the same number of digits, while checking if the array is sorted should be faster
on smaller arrays where the largest number have considerable more digits than the other numbers in the array.\*

###  \*Speed Test:
Conducting speed tests using the SpeedTest class, shows that over 100 000 iterations, with an array of size 2 000 containing random values between 0 and 10 000, checking if the array
is sorted, was *faster* by about 6 000 nano seconds. But with an array size of 10 000 checking if it is sorted was *slower* by about 10 000 nano seconds.
The average time that each iteration took was-

For array size of 2000:
- *isSorted* - 50 567 nano sec
- *checking largest* - 56 628 nano sec

For array size of 10000:
- *isSorted* - 519 917 nano sec
- *checking largest* - 509 929 nano sec
