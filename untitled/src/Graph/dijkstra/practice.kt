package Graph.dijkstra

import java.util.*

// WOrk on the network delay time here

// Given the [u, v, w] w =the time it takes from u to v

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val adj: MutableMap<Int, MutableList<IntArray>?> = HashMap()
    for (i in flights)  // The 2nd value is the price
        adj.computeIfAbsent(
            i[0]
        ) { value: Int? -> ArrayList() }!!
            .add(intArrayOf(i[1], i[2]))
    val stops = IntArray(n)
    Arrays.fill(stops, Int.MAX_VALUE)

    // When you poll
    val pq = PriorityQueue { a: IntArray, b: IntArray ->
        a[0] - b[0]
    }


    // {the price here , node, number_of_stops_from_src_node}
    pq.offer(intArrayOf(0, src, 0))
    while (!pq.isEmpty()) {
        val temp = pq.poll()
        val price = temp[0]
        val node = temp[1]
        val steps = temp[2]
        // We have already encountered a path with a lower cost and fewer stops,
        // or the number of stops exceeds the limit.
        if (steps > stops[node] || steps > k + 1) continue
        stops[node] = steps
        if (node == dst) return price
        if (!adj.containsKey(node)) continue
        for (neigh in adj[node]!!) {
            pq.offer(intArrayOf(price + neigh[1], neigh[0], steps + 1))
        }
    }
    return -1
}