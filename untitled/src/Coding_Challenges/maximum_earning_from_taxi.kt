//package Coding_Challenges
//
//import java.util.*
//
//// n points you are driving on here
//// 1- n
//
//// rides = [ start, end, tip]
//// point= [start, end]      get a tip dollar tip
//// Each passenger = [end - start + tip ]    # max num of dollars
//
//
//// Once you see a customer either pick or no pick
///*
//1. Until customer ends no more customer, once you pick a cust,
//you earn some dollars
//2. define the dp(i) here
//3. dp[i] = start from the ith pa
//
//[1, 6, 1], [3, 10, 2]       can't choose 1 and 2, since idx 1 ends at
//6
//
//The link for this video is here
// */
//
///*
//Create a map with Map<Integer, List<int[]>>
//<the ending pt>,<the passenger with ending pt at the key>
//
//dp table
// the profit    0  0  0  0   0   0   6  6  6  6  9
// the stop pts  0  1  2  3   4   5   6  7  8  9
//    At idx, we get 6-1+1 = 6 so we put 6 there
//    From 0-5 it stays at 0, since we are still carrying psgers no drop off
//    yet.
//
//     the profit    0  0  0  0   0   0  6  6  6  9  9
// the stop pts  0  1  2  3   4   5   6  7  8  9  10 11
//    At i = 10, max is 9  [10-3 + 2]= 9 this will be maxi but you
//    are ignoring 6, can only take 1 passenger
//    so we take [3, 10, 2] instead of [1, 6, 1]
//
//        [10, 12, 3] and [11, 12, 2]
//       the profit    0  0  0  0   0   0  6  6  6  9  9  14
// the stop pts  0  1  2  3   4   5   6  7  8  9  10  11  12
// idx = 12 what's the maxi? So 2 values for stop pt 12,
//    We have to comapre
//    We also have to add dp[10] from before  [from the stop pt]
//    So would be 9 + 5 = 14
// */
//// max taxi earning here
//fun maxTaxiEarnings( n: Int, rides: Array<IntArray>): Long {
//
//
//    // Also 2d arr
//    val g = Array(n) { IntArray(n) }
//    for(r in rides){
//        // r[0] = start, r[1]= end, r[2] = tip
//        g[r[0]][r[1]] = r[2]
//    }
//    // A max heap here
//    val maxHeap = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
//
//    // get the best one out of the answers here
//    maxHeap.offer(intArrayOf(0, ))
//    while(!maxHeap.isEmpty()){
//
//        val cur = maxHeap.poll()
//        val price = cur[0]
//        val dest = cur[1]
//
//        // Make sure dest >
//    }
//}