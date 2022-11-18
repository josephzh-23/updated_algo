import java.lang.Integer.min
import java.util.*
//O : amount * len(coins)
// o: amount for the array here
fun coinChange(coins: IntArray, amount: Int): Int {
    Arrays.sort(coins)
    val dp = IntArray(amount + 1)
    Arrays.fill(dp, amount + 1)
    // Only take 0 coins at the start
    dp[0] = 0
    for (a in 1 until amount + 1) {

        // go thru all the coins in there and for each amount
        for (c in coins) {

            // then we need to continue searching then
            if ((a - c) >= 0) {
                dp[a] = min(dp[a], 1 + dp[a - c])
            }
        }
    }
    // Check if the dp[amount] is the default value the
    // only case to return
    println(dp[amount])
    return if (dp[amount] != amount + 1) dp[amount] else -1
}

/*

Given a coin make up the amount smallest possibilities
[1, 2, 5]     ->       11
output  3:      [5 + 5 + 1]
 */
fun main() {
    var arr = intArrayOf(1, 2, 5)

    coinChange(arr, 11)
}