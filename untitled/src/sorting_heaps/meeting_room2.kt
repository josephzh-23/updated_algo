package sorting_heaps

import January_3rd.print
import java.util.*

// Given an arrya of time intervals where intervals[i] = [start, end]
fun main() {
    var meet = arrayOf(
        intArrayOf(0, 30), intArrayOf(5, 10),
        intArrayOf(15, 20)
    )
    canAttendMeetings2(meet).print()
}

fun canAttendMeetings2(intervals: Array<IntArray>): Boolean {
    // Chekc if you can attend all the meetigngs


    var count = 0
    Arrays.sort(intervals) { a, b -> a[0] - b[0] }

    for (i in 0 until intervals.size) {

        // End of the first one bigger than end of the 2nd here
        if (intervals[i][1] <  intervals[i + 1][1]) {
            count++
        }

    }
    println(count)
    return true
}