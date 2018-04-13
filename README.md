# RadixSort-Java
My attempt at implementing Radix Sort in java.

*Currently neither file contains a MSD sort method.*

The **OldRadix.java** is the older *(and more readable)* version of **Radix.java**, **Radix.java** is an optimized version of **OldRadix.java**.

**Radix.java** was optimized by replacing the *'ArrayList< ArrayList<Integer> >'* with an int array, and also by replacing the *'isSorted'* check by a faster check.
Now instead of iterating over the whole array to check is it's ordered, it just sees if the multiplier(*'mult'*) is bigger than the largest number, which is obtained at the start of the sorting method.
However, in some cases it will perform more iterations than than if *'isSorted'* was used, because it does not know for sure
that the array is sorted until it has iterated over every digit of the largest number in the array.

In theory, the largest number method should be faster on large arrays where all numbers have about the same number of digits, while checking if the array is sorted should be faster
on smaller arrays where the largest number have considerable more digits than the other numbers in the array.\*

###  *Speed Test:
Conducting speed tests using the SpeedTest class shows that over 100 000 iterations, with an array of size 2 000 containing random values between 0 and 10 000, checking if the array
was sorted was *slower* by about 7 000 nanoseconds. And with an array size of 10 000 checking if it was sorted was *faster* by about 18 000 nanoseconds.
The average time that each iteration took was...

...for array size of 2 000:
- *isSorted* - 220 048 nanosec
- *checking largest* - 213 263 nanosec

...for array size of 10 000:
- *isSorted* - 1 178 572 nanosec
- *checking largest* - 1 196 311 nanosec

## Update: Negative arrays
There are now two sorting methods for the LSD algorithm, one that only sorts arrays with positives and one that also sorts arrays with negatives.
The method that sorts arrays with negatives is considerably slower than the one that only sorts positives.

SpeedTest.java was also updated, it had a bug where it sorted the array, and then tried to sort that array (which was already sorted) with the other method.

OldRadix.java also had to be fixed because it was not actually going through the whole array to check if it was sorted.
