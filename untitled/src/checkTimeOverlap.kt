import java.lang.Integer.max
import java.lang.Integer.min

/*

slotsA = [[10, 50], [60, 120], [140, 210]]
slotsB = [[0,15], [60, 70]]
dur = 8

teh amount of time they want to meet for
Output:
1. [60, 68]
and you want the earlist time
2. You want the earliest time they can meet

Constraints:
are they sorted in anyway? sorted by start time

 */


/*
Approach: using 2 pters,
A and B are both sorted here
may not be necessary

3. There is overlap and overlap >= duration

The reason we use max(starts) and min(ends) here is because
we want the earliest time possible.
1) A is inside B and b inside A
2) or A.end >= B.start or B.end >= A.start
3) overlap section = max(a.start, b.start) and min(a.end, b.end)
4. There is overlap and overlap < duration
 */



fun checkTimeOverlap(list1: Array<IntArray>, list2: Array<IntArray>,
                     dur: Int) {
    // 2 pointers above
    var (l, r) = Pair(0, 0)
    var overlap = intArrayOf()
    while (l < list1.size && r < list2.size) {

        var a = list1[l]
        var b = list2[r]

        // a.end < b.start
        // the following part actually not necessary
//        if (a[1] < b[0]) {
//            l++
//            continue
//        } else if (b[1] < a[0]) {
//            r++
//            continue
//        }

        // the overlap here
        overlap = intArrayOf(max(a[0], b[0]), min(a[1], b[1]))
        var diff = overlap[1] - overlap[0]
        if(diff >= dur){
            println("${overlap[0]}  and ${overlap[0]+ dur}")
        }else{


            // Need to move up the one with lower end value
            if(a[1] < b[1]){
                l++
            }else{
                r++
            }
        }
    }
}

fun main() {
    val slotsA = arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210))
// The next 2 would be empty here
    val slotsB = arrayOf(intArrayOf(0, 15), intArrayOf(60, 70))
    checkTimeOverlap(slotsA, slotsB, 8)

    // What are some edge cases here

}