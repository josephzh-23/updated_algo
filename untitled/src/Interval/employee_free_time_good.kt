import Heap.Interval
import java.util.*


fun main() {
    var arr = arrayListOf(arrayListOf(Interval(1, 2),
            Interval(5, 6)), arrayListOf(Interval(1, 3)), arrayListOf(Interval(4, 10)))
    employeeFreeTime2(arr)
}

/*
run time O(nlgn)
space O(n)
 */

fun employeeFreeTime2(schedule: List<List<Interval>>): List<Interval> {
    val res: MutableList<Interval> = ArrayList()

    // sort by start time
    val pq = PriorityQueue { a: Interval, b: Interval -> a.start - b.start }
    for (list in schedule) {
        for (interval in list) {
            pq.offer(interval)
        }
    }
    var cur = pq.poll()
    while (!pq.isEmpty()) {
        val next = pq.poll()
        if (cur.end >= next.start) { // no free time
            // update the end
            next.end = Math.max(cur.end, next.end)
        } else { // free time between them
            res.add(Interval(cur.end, next.start))
        }
        cur = next
    }
    return res
}