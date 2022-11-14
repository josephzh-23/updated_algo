package Dynamic_programming

import java.util.*

// Start from the base case and reach our goal
/*
Set an iterative loop which traverses the array( from index 2 to n)
and for every index set its value as dp[i-1] + dp[i-2].

basically we start from the back as mentioned
 */


// There is an even improved approach to this without using array
internal object TUF4 {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 5
        val dp = IntArray(n + 1)
        Arrays.fill(dp, -1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        println(dp[n])
    }
}
