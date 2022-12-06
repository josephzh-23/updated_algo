package Array


import java.util.*;
/*
Time Complexity: O(nlog(n))
Auxiliary Space: O(1)
*/
// Sort so all same elem right next to each other
// Check for consecutive occurences

fun mostFrequent(arr: IntArray){

    Arrays.sort(arr)
    var max_count = 1
    var curCount = 1
    var res = arr[0]
    // All same elem next to each other

    for(i in 1 until arr.size){
        // Check if same as the one before
        if(arr[i] == arr[i-1]){
            curCount++

            // The first time here
        }else{
            curCount =1
        }

        if (curCount > max_count) {
           max_count = curCount
            res = arr[i - 1];
            println(res)
        }
    }
}


// Driver program
fun main(args: Array<String>) {
    val arr = intArrayOf(40, 50, 30, 40, 50, 30, 30)
    val n = arr.size
    System.out.println(mostFrequent(arr))
}