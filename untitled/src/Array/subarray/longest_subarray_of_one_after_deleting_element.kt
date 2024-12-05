package Array.subarray

import kotlin.math.max


/*

ANd then here are the data that we need here
- and then we have the code

You can delete 1 element return the longest array containing only 1
in this array here

And then here we have the code
 */

fun longestSubarray(nums: IntArray): Int {
    // Number of zero's in the window.
    var zeroCount = 0
    var longestWindow = 0
    // Left end of the window.
    var s = 0

        /*

        If in the example below we have the code
        0 1 1 1 0 1 1 0 1

        s       i

    In the window above the size is 4 there r 2 zeros, so we move s to 1
    0 1 1 1 0 1 1 0 1

      s     i

    And now the window above will have i - start
         */
    for (i in nums.indices) {
        zeroCount += (if (nums[i] == 0) 1 else 0)


        // Shrink the window until the count of zero's
        // is less than or equal to 1.

        // We allow 1 zero here because that's the one that we want to delete
        while (zeroCount > 1) {
            zeroCount -= (if (nums[s] == 0) 1 else 0)
            s++
        }

        longestWindow = max(longestWindow, i- s)
    }

    return longestWindow
}
