package Dynamic_programming

import java.util.*
import kotlin.collections.ArrayList

// n points you are driving on here
// 1- n

// rides = [ start, end, tip]
// point= [start, end]      get a tip dollar tip
// Each passenger = [end - start + tip ]    # max num of dollars


// Once you see a customer either pick or no pick
/*
1. Until customer ends no more customer, once you pick a cust,
you earn some dollars
2. define the dp(i) here
3. dp[i] = start from the ith pa

[1, 6, 1], [3, 10, 2]       can't choose 1 and 2, since idx 1 ends at
6

The link for this video is here
 */

/*
https://leetcode.com/problems/maximum-earnings-from-taxi/description/
Create a map with Map<Integer, List<int[]>>
<the ending pt>,<the passenger with ending pt at the key>

formula     earning = end - start + tip
dp table
 the profit    0  0  0  0   0   0   6  6  6  6  9
 the stop pts  0  1  2  3   4   5   6  7  8  9
 baesd on the data [1, 6, 1]
    At idx 6, we get 6-1+1 = 6 so we put 6 there
    From 0-5 it stays at 0, since we are still carrying psgers no drop off
    yet.

     the profit 0  0  0  0   0   0  6  6  6  9  9
 the stop pts  0  1  2  3   4   5  6  7  8  9  10 11
 Based on [3, 10, 2]
    At i = 10, max is 9  [10-3 + 2]= 9 this will be > 6 from previous,
     so  you  are ignoring 6, can only take 1 passenger
    so we take [3, 10, 2] instead of [1, 6, 1]

        [10, 12, 3] and [11, 12, 2]
       the profit    0  0  0  0   0   0  6  6  6  9  9  14
 the stop pts    0  1  2  3   4   5   6  7  8  9  10 11  12
 idx = 12 what's the maxi? So 2 values for stop pt 12,

 If we take 1st one:
  we take [10, 12, 3] bigger value
    We also have to add dp[10] from before  [from the stop pt]
    So would be 9 + 5 = 14      the maximum

    If we take 2nd one      [11, 12, 2] then it becomes below
        12- 11 + 2 + dp[11]     3+ dp[11] = 12
    Conclusion (we will take the first one) gives us 14
 */
// max taxi earning here
// 3 values here
fun maxTaxiEarnings( n: Int, rides: Array<IntArray>): Long {
    // For each end: there would be a list of values here
    // end : [start, price]
    var map:MutableMap< Int, ArrayList<IntArray>> = HashMap()
    for(r in rides){
        var values = map.get(r[1])

        // end: []
        if(values == null){
            values = ArrayList()
            map.put(r[1], values)
        }
        // end: [1, 2]      example
        values.add(r)
    }

    var dp = IntArray(n+ 1)

    // WHy start at 2
    for(i in 2 until n){
        var values = map.get(i)
        if(values!=null){
            var earning = 0
            for(value in values){
                // [10, 12, 3]     and [11, 12, 2]  take 1st one
                // 5 + dp[10]
                // take 2nd one     12- 11 + 2 + dp[11]
                earning  = Math.max(earning, value[1] - value[0] + value[2] + dp[value[0]])
            }
            // When you get down to here then
            // [10, 12, 3]     and [11, 12, 2]
            dp[i] = earning
        }
        // Always take the maximum of the value down here
        dp[i] = Math.max(dp[i], dp[i-1])
    }
    return dp[n].toLong()
}

fun main() {
    // Should give 20 over here
    var n = 5
    var arr = arrayOf(intArrayOf(1, 6, 1),
            intArrayOf(3, 10, 2),
            intArrayOf(10, 12, 3),
            intArrayOf(11, 12, 2),
            intArrayOf(12, 15, 2),
            intArrayOf(13, 18, 1))
    maxTaxiEarnings(5,arr )
}