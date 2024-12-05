package Sliding_window.Basic

import java.lang.Integer.min


fun dynamicSlidingWindow(arr: IntArray, x: Int){
    var minLength = Int.MIN_VALUE

    // Current range and sum of sliding window
    var (start, right, curSum) = intArrayOf(0, 0, 0)

    // Expand window until met
    while(right < arr.size){
        curSum += arr[right]
        right += 1

        // Contract window until no longer meet condition
        while(start < right&& curSum >=x){
            curSum -= arr[start]
            start += 1

            // Update the min Length if shorter
            minLength = min(minLength, right - start + 1)
        }
    }

}
