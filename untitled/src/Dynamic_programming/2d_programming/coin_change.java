import java.util.Arrays;


/*

coins= [2]
Start with the smaller problem dp[n] = fewest # of coins to make up n amount of
money
 */
class Solution15{

    public int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i= 0; i<= amount; i++){

            // go thru all the coins in there and for each amount
            for(int j =0; j< coins.length; j++){

                // dp[i] the amount that we need dp[3] = min # of coins
                // to get to $3        2 < 3, we can take the coin
                // dp[i - coins[j]]     ex:dp[ 5 - 2 ]      tar = 5, coins[j] =2
                //
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }else{
                    break;
                }

            }
        }
        // Check if the dp[amount]
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}