//package Graph
//
//// Use topological sorting here
//
//// How to find the cycle here
//
//// 1, 0 here the code given [1, 0]
//
//// For the course schedule // Given a [0, 1] here
//fun canFinish(n: Int, prerequisites: Array<IntArray>): Boolean {
//
//    // Here given pre -requ
//    var adj = Array<ArrayList<Int>>(n) { ArrayList() }
//
//
//    var visited = BooleanArray(n)
//    prerequisites.forEach { edge ->
//        var start = edge[0]
//        var end = edge[1]
//        adj[start].add(end)
//        adj[end].add(start)
//    }
//
//    for (i in 0 until n) {
//        if (!visited[i]) {
//            dfs2(adj, visited, i)
//        }
//    }
//
//
//}
//
//fun isCyclic(node: Int): Boolean{
//
//
//}
//
//fun dfs2(
//    adj: Array<ArrayList<Int>>,
//    isVisited: BooleanArray, vertex: Int
//) {
//
//    if (isVisited[vertex]) {
//        return
//    }
//    isVisited[vertex] = true
//    for (neigh in adj[vertex]) {
//        dfs2(adj, isVisited, neigh)
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
