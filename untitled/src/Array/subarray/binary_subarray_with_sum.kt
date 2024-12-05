package Array.subarray
/*

You have nubmers array and then  you have  asum here

We use two sliding windows: one to find the number of subarrays with sum just over goal (s1 and i1),
and another to find the number of subarrays with sum equal to or just over goal (s2 and i2).

As we move the main pointer j through the array, we increase s1 and s2 by the new element included in the window nums[j].


Next, we need to shrink the windows if necessary. If s1 is > goal,

    we move i1 to reduce the window and the sum. Similarly, if s2 is >= goal, we move i2.


The difference between i2 and i1 gives us the number of new subarrays that have a = goal considering the new element nums[j].

    We increment ans by this difference since i2 - i1 represents the number of valid subarrays ending at j with sum exactly goal.
We repeat this process for every element of the array by incrementing j, thus exploring every potential subarray.

    Why does this work? The two sliding windows track the lower and upper bounds of sums around our goal. By taking the difference of the counts, we effectively count only those subarrays whose sum is exactly goal.
Since we consider each subarray ending at various j positions, we can ensure that all possible subarrays are counted.
 */

fun binarySubArrayWIthSum(nums: IntArray, goal: Int): Int {
    /*

    Use 2 sliding windows here
    s1 and s2 used to track the sums of number with in the window here

    ANd then next
    1. Find the # of subarray
    2.
     */
    var (left1, left2, sum1, sum2, idx) = intArrayOf(0, 0, 0, 0, 0)
    var totalSubarrays = 0

    var arrayLen = nums.size

    while (idx < arrayLen) {

        //Increase running sums with the current number
        sum1 += nums[idx]
        sum2 += nums[idx]


//        # Decrease sum1 until it 's no more than goal by moving left1 pointer right
        while (left1 <= idx && sum1 > goal) {
            sum1 -= nums[left1]
            left1 += 1
        }

//        # Decrease sum2 until it 's just less than goal by moving left2 pointer right
        while (left2 <= idx && sum2 >= goal) {
            sum2 -= nums[left2]
            left2 += 1
        }



//        # Add the number of new subarrays found to the total
        totalSubarrays += left2 - left1
//
//        # Move to the next element
        idx += 1
    }
    return totalSubarrays
}
















