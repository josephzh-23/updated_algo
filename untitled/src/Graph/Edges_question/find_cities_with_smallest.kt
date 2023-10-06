//package Graph.Edges_question
//
//import java.util.*
//
//// Find the City With the Smallest Number of Neighbors at a Threshold Distance
//
//// [from , to, weight] here
//
//// Distance at most distanceThreshold
//
//fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
//
//    val adj: MutableMap<Int, MutableList<IntArray>?> = HashMap()
//
//    // For the boolean array we need to know # of vertices usually given
//    // in the questions
//    val visited = BooleanArray(n)
//    edges.forEach { e ->
//
//        adj.computeIfAbsent(e[0]) { ArrayList() }?.add(intArrayOf(
//                e[1], e[2]
//        ))
//        adj.computeIfAbsent(e[1]) { ArrayList() }?.add(intArrayOf(
//                e[0], e[2]
//        ))
//    }
//
//    // Use this to store all the updated distance to each node
//    val numCity = IntArray(n)
//    Arrays.fill(numCity, -1)
//
//    // When you poll
//    // [price,
//    val pq = PriorityQueue { a: IntArray, b: IntArray ->
//        a[0] - b[0]
//    }
//    pq.add(intArrayOf())
//    while (!pq.isEmpty()) {
//        val temp = pq.poll()
//        val dist = temp[0]
//        val node = temp[1]
//
//        // We have already encountered a path with a lower cost and fewer stops,
//        // or the number of stops exceeds the limit.
//        if (dist > distanceThreshold) continue
//
//        numCity[]
//        // Need to store the number of steps for that node in particular here
//        // SO no more processing if sth similar occurs here
////        stops[node] = steps
//        if (!adj.containsKey(node)) continue
//        for (neigh in adj[node]!!) {
//            // neigh
//            // So basically here you have the node
//            // neigh[0] = the end
//            // neigh[1] = the distance here
//            pq.offer(intArrayOf(neigh[1], neigh[0]))
//        }
//    }
//
//    return numCity.max() ?: 0
//}
//
