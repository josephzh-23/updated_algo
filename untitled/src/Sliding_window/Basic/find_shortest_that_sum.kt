package Sliding_window.Basic

import java.lang.Integer.min

fun main() {
// Say you have a sum of 7 over here and then the foolowing
// When does it sum up to 7?

    var sum = intArrayOf(1, 2, 3, 4, 5, 6)
    print(dynamicSlidingWindow(sum, 7))

}

fun dynamicSlidingWindow(arr: IntArray, x: Int): Int {

    var minLength = Int.MIN_VALUE

    // Current range and sum of our window
    var (start, end, curSum) = listOf(0, 0, 0)


    // Expadning the slidign window until our criteria is met
    while (end < arr.size) {

        curSum = curSum + arr[end]
        end = end + 1

        // Contract the sliding window until no longer meet the condition
        while (start < end && curSum >= x) {

//            println("cur sum  is $curSum")
            curSum = curSum - arr[start]
            start = start + 1
            // Update the min length if shorter then what we had before
            minLength =
                if (minLength < 0) {
                    end - start + 1
                } else {
                    min(minLength, end - start + 1)
                }

            // This is expected here
            println("answer is $minLength")
        }
    }
    return minLength
}
