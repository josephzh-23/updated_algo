package Dynamic_programming

import java.util.*

// O: O(n)
// Using memoization
internal object TUF {
    fun f(n: Int, dp: IntArray): Int {
        if (n <= 1) return n

        // This checks to see if we have already solved the sub problem
        // Ex: if 2nd call to f(n=4) dp[2] !=-1

        // since already solved, so we return dp[2] as answer
        return if (dp[n] != -1) dp[n] else f(n - 1, dp) + f(n - 2, dp).also { dp[n] = it }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val n = 5
        val dp = IntArray(n + 1)
        Arrays.fill(dp, -1)
        println(f(n, dp))
    }
}