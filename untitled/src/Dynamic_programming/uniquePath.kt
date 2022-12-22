package Graph

import Graph.Top_6.isOutOfBounds
import java.util.*

// what we can do is add the bottom left, center and right stuff unto the point here
//
// Time complexity : O(M*n)
// SC: O(m*n)       we init a 2d grid here 
fun uniquePaths(m: Int, n: Int): Int {
    // YOu always either look to left of you or at the bottom here

    var dp = Array(m) { IntArray(n) }

    for(i in 0 until m){
        for(j in 0 until n){
            // THe first row always 1 and first col = 1
            if(i ==0||j==0){
                dp[i][j] = 1
            }else{
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
    }
    return dp[m-1][n-1]
}





