package Sliding_window

import kotlin.math.max

fun main() {
    println(maxSubarrayLength(charArrayOf('a', 'b', 'c', 'a', 'b', 'c', 'a', 'b'), 2))
}
/*

How does this work here?


 */
fun maxSubarrayLength(nums: CharArray, k: Int): Int {
    var ans = 0
    var start = -1
    val frequency = mutableMapOf<Char, Int>()

    /*
        Basically here whenever the length > k, we need to start contracting the window here
    and this is very important
     */
    for (end in nums.indices) {
        frequency[nums[end]] = frequency.getOrDefault(nums[end], 0) + 1
        while (frequency[nums[end]]!! > k) {
            start++
            frequency[nums[start]] = frequency[nums[start]]!! - 1
        }
        ans = max(ans.toDouble(), (end - start).toDouble()).toInt()
    }

    return ans
}
