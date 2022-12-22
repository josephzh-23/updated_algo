package Graph.Cycle_detection

/*

https://www.youtube.com/watch?v=uzVUw90ZFIg&t=432s
The dfs for the undirected grpah would not work here
Directed means for the below:
The concept is as above:
 3  - 4 - 5
3-  6 -5        there is no cycle here

But for undirected the above would cause a cycle
b/c 3-5

 */

/*
Cycle here      7  -  2,
8 - 9       9 - 7           a cycle at 7 here
There would be 2 visited arrays, 1 for visited and 1 for
dfs_visited (also known as explored)
Each time you visit a node, mark all node as 1 and check its neigbor

How to know cycle?
So when you see a node visited[n] = true dfsVisited[n] = true
you know this has been visited here

TC: O(n+ e)     # of ndoes + edges here
SC: O (2n)

 */



internal object Solution5 {
    @JvmStatic
    fun main(args: Array<String>) {
        val V = 6
        val graph = ArrayList<ArrayList<Int>>(V)

        //Vertex - 0
        var neighbors = ArrayList<Int>()
        neighbors.add(1)
        graph.add(neighbors)

        //Vertex - 1
        // 1 : [2, 5]
        neighbors = ArrayList()
        neighbors.add(2)
        neighbors.add(5)
        graph.add(neighbors)

        //Vertex - 2
        neighbors = ArrayList()
        neighbors.add(3)
        graph.add(neighbors)

        //Vertex - 3
        neighbors = ArrayList()
        neighbors.add(4)
        graph.add(neighbors)

        //Vertex - 4
        neighbors = ArrayList()
        neighbors.add(0)
        neighbors.add(1)
        graph.add(neighbors)

        //Vertex - 5
        neighbors = ArrayList()
        graph.add(neighbors)

        // CHeck if node visited and hten here
        if (isCyclic(V, graph)) println("Cycle detected") else println("No cycles detected")
    }

    private fun checkCycle(node: Int, adj: ArrayList<ArrayList<Int>>, vis: IntArray, dfsVis: IntArray): Boolean {

        //check the cycle here
        vis[node] = 1
        dfsVis[node] = 1
        for (neighbor in adj[node]) {

            // If it hasn't been visited then check if there is cycle or not xxx
            if (vis[neighbor] == 0) {
                if (checkCycle(neighbor, adj, vis, dfsVis) == true) {
                    return true
                }
                // 1 is for dfs visited and the other for the visited as said
                // right so they are alot more similar than you thought
            } else if (dfsVis[neighbor] == 1) {
                return true
            }
        }
        dfsVis[node] = 0
        return false
    }

    fun isCyclic(N: Int, adj: ArrayList<ArrayList<Int>>): Boolean {
        val vis = IntArray(N)
        val dfsVis = IntArray(N)
        for (i in 0 until N) {
            if (vis[i] == 0) {
                if (checkCycle(i, adj, vis, dfsVis) == true) return true
            }
        }
        return false
    }
}


