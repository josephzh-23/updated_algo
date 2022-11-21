package Sliding_window

import java.util.*
import kotlin.collections.HashMap


// So at most 2 char are different
// Use 2 pter l and r, move the r pter when contain < 2 char
//  if > 3 char, then move l pter

fun longestSubstringTwoMostCharacters(s: String):Int{

    var n = s.length
    var l = 0 ; var r = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    val hp = HashMap<Char, Int>()

    var maxLen = 2

    while(r< n){
        // when the slidewindow contains less than 3 characters
        // e 1
        // b 2
        hp.put(s[r], r++)

        if(hp.size ==3){

            // Delet the left most character since window
            // need to be slided now
            val idxDel = Collections.min(hp.values)
            //delete this char
            hp.remove(s[idxDel])

            l = idxDel + 1
        }
        maxLen = Math.max(maxLen, r - l)
    }

    println(maxLen)
    return maxLen

    return 0
}

fun main() {
    longestSubstringTwoMostCharacters("eceba")
}