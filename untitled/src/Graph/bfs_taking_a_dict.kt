package Graph

import java.util.*


// Remember in the dfs case, we used a list here
fun main() {

    bfsGraph(null, 2)


}
// O (V + E)
fun bfsGraph(data: Array<IntArray>?, start: Int): Int {
    val times1 = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
    );
    val graph: MutableMap<Int, MutableList<Int>> = HashMap()

    // and using the above we have
    //graph.put(1, [1, 2, 3, ])
    times1.forEach{time->
        var src = time[0]
        var tar = time[1]

        // If not contain, then init a new list
        if (!graph.containsKey(src)) {
            graph[src] = LinkedList()
        }
        graph[src]?.add(tar)
    }
    graph
    // Now unto the q and set
    var q = LinkedList<Int>()
    val visited = BooleanArray(10)

    q.add(start)
    visited[start] = true
    while(!q.isEmpty()){
        var node = q.pop()
        println("the popped queue is $node")

        // traverse thru the neighbor
        graph[node]?.forEach{neigh->
            println(neigh)
            if(!visited[neigh]){
                visited[neigh] = true
                q.add(neigh)
            }
        }
    }

    return 0
}
