package Graph.Top_6


//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Taken from number of connected components
/*
Basically the idea is that you move in here
        One solution is to use DFS.
        The idea is to give each node a flag to mark whether it has been visited.
         For an unvisited node, we will increment the result by 1,
         And then we traverse the neighboring nodes through the adjacency list and
         mark them as visited.
 */

fun main(){

    println(countComponents(5, arrayOf(intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(3, 4))))
}
fun countComponents(n: Int, edges: Array<IntArray>): Int {
    var res = 0

    val adj = Array<ArrayList<Int>>(n){ ArrayList() }
    val visited = BooleanArray(n)
    edges.forEach{edge->
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    }
    for(i in 0 until n){
        if(!visited[i]){
            res++
            dfs(adj, visited, i)
        }
    }
    return res
}

fun dfs(adj: Array<ArrayList<Int>>, isVisited: BooleanArray, i: Int) {
   if(isVisited[i]){
       return
   }
    isVisited[i] = true
    // loop throgh the node
    for(j in 0 until adj[i].size){
        dfs(adj,isVisited, adj.get(i).get(j))
    }
}