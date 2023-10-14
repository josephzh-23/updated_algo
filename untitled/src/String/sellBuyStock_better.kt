package String

import java.lang.Integer.max


fun buySellStockBetter(prices: IntArray): Int {

    var (l, r) = Pair(0, 1)
    var maxp = 0
    while(r < prices.size){
        if(prices[l] < prices[r] ){
            val profit = prices[r] - prices[l]
            maxp = max(maxp, profit)
        }else{
            // Make sure this updated
            // if left becomes bigger here
            l = r
        }
        r+=1
    }
    return maxp
}