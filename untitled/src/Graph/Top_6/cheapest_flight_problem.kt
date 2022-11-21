package Graph.Top_6

import java.util.*
//flights where flights[i] = [fromi, toi, pricei]

// Time Limit Exceeded
internal class Solution1 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val g = Array(n) { IntArray(n) }
        for (f in flights) {
            g[f[0]][f[1]] = f[2]
        }
        // A min heap here  a[0] means the first idx the array here basically
        val minHeap = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }

        // 0 is the price at the beginning
        minHeap.offer(intArrayOf(0, src, K + 1))
        while (!minHeap.isEmpty()) {
            val cur = minHeap.poll()
            val price = cur[0]
            val place = cur[1]
            val remainStops = cur[2]
            if (place == dst) return price
            if (remainStops > 0) {
                for (i in 0 until n) {
                    if (g[place][i] > 0) {
                        minHeap.offer(intArrayOf(price + g[place][i], i, remainStops - 1))
                    }
                }
            }
        }
        return -1
    }
}
