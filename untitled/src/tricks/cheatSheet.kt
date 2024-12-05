package tricks

import java.util.*


fun main() {

// For loop here
    var arr = arrayOf(1, 23, 3)
    // Dictionary which keeps a count of all the unique characters in t.
    for (i in 0 until arr.size) {

        // And below is the answer here
        println(arr[i])
    }

    // Dealing with string
    // convert a string to words
    var str = "fdasdfas"
    var acc = str.toCharArray()

    // Using the map
    var endChar = 'c'
    var map = mutableMapOf<Char, Int>()
    var count = 0
    if (map.containsKey(endChar)) { // Decrement this value in 1
        map.put(endChar, map.getOrDefault(endChar, 0) - 1)
        if (map[endChar] == 0) count -= 1
    }




}
