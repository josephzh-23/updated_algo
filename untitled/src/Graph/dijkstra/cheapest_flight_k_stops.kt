package Graph.dijkstra

import January_3rd.print
import java.util.*


// A very elegant solutino here and passes all types of tests here


// The solution then becomes

fun main() {

    var s = arrayOf(
        intArrayOf(0, 1, 100), intArrayOf(1, 2, 100),
        intArrayOf(2, 0, 100), intArrayOf(1, 3, 600), intArrayOf(2, 3, 200)
    )
    findCheapestPrice2(4, s, 0, 3, 1).print()
    // Let's try to do this here
}

fun findCheapestPrice2(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
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


        // Need to store the number of steps for that node in particular here
        // SO no more processing if sth similar occurs here
        stops[node] = steps
        if (node == dst) return price
        if (!adj.containsKey(node)) continue
        for (neigh in adj[node]!!) {

            // So basically here you have the node
            // neigh[0] = the end
            // neigh[1] = the price here
            pq.offer(intArrayOf(price + neigh[1], neigh[0], steps + 1))
        }
    }
    return -1
}