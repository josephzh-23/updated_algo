package Graph

import java.util.*

// The problem here begins with

// Every adjacent pair of words differs by a single letter.
// differ by a letter ?

fun check2Words(s1: String, s2: String){

// check the 2 words see if the same
   var s1 = sortString(s1)
    var s2 = sortString(s2)

    // abce  abcf


}

fun sortString(inputString: String): String {
    // Converting input string to character array
    val tempArray = inputString.toCharArray()

    // Sorting temp array using
    Arrays.sort(tempArray)

    // Returning new sorted string
    return String(tempArray)
}