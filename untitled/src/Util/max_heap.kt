package Util

import java.util.*

object maxheap {
    @JvmStatic
    fun main(args: Array<String>) {
        val k = 4
        val nums = intArrayOf(1, 2, 3, 4)
        val count: MutableMap<Int?, Int?> = HashMap<Int?, Int?>()
        for (n in nums) {
            count[n] = count.getOrDefault(n, 0)!! + 1
        }
        printDictionary((count as HashMap<*, *>))

        // init heap 'the less frequent element first'
        val heap: Queue<Int> = PriorityQueue { n1: Int?, n2: Int? -> count[n1]!! - count[n2]!! }
        for (n in count.keys) {
            heap.add(n)
            //            if (heap.size() > k) heap.poll();
        }
        println(heap.poll())
    }
}