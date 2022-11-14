package Graph.Top_6

import java.util.*


// Time Limit Exceeded
internal class Solution1 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val g = Array(n) { IntArray(n) }
        for (f in flights) {
            g[f[0]][f[1]] = f[2]
        }
        val heap = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
        heap.offer(intArrayOf(0, src, K + 1))
        while (!heap.isEmpty()) {
            val cur = heap.poll()
            val price = cur[0]
            val place = cur[1]
            val remainStops = cur[2]
            if (place == dst) return price
            if (remainStops > 0) {
                for (i in 0 until n) {
                    if (g[place][i] > 0) {
                        heap.offer(intArrayOf(price + g[place][i], i, remainStops - 1))
                    }
                }
            }
        }
        return -1
    }
}
