package Real_world_graph

import java.util.ArrayList
import kotlin.math.max

fun main() {

    // n is the number of employees here
    var n = 6;
    var headId = 2
    var manager = intArrayOf(2, 2, -1, 2, 2, 2)
    var informTime = intArrayOf(0, 0, 1, 0, 0, 0)
    print(findTimes(6, headId, manager.toList(), informTime.toList()))
}

var maxTime = 0
fun findTimes(n: Int, headID: Int, managers: List<Int>, informTime: List<Int>): Int {
    /*
    An adjacency list ith index : store the adjacent nodes to the employee with id i
    for each employee :
    store an edge manager[i] -> i if maanger isn't -1
    3. Update the maximum here
     */

    val adj = Array<ArrayList<Int>>(n) { ArrayList() }
    /*
    For the number of employees
    store an edge manager[i] -> i if maanger isn't -1
     */
    for (i in 0 until n) {
        if (managers[i] != -1) {
            val manager = managers[i]
            adj[managers[i]].add(i)
        }
    }

    dfs2(adj, informTime, headID, 0)
    return maxTime
}


// Cur would basically be the head id here
fun dfs2(adj: Array<ArrayList<Int>>, informTime: List<Int>, cur: Int, time: Int) {

    maxTime = max(maxTime, time)
    // loop throgh the node same as verticies
    for (neigh in adj[cur]) {
        dfs2(adj, informTime, neigh, time + informTime[cur])
    }
}