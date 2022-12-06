internal class Solution5 {
    lateinit var seen: MutableSet<Int>
    var MAX_EDGE_VAL = 1000
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val graph: Array<ArrayList<Int?>> = arrayOfNulls<ArrayList<*>>(MAX_EDGE_VAL + 1)
        for (i in 0..MAX_EDGE_VAL) {
            graph[i] = ArrayList<Any?>()
        }
        for (edge in edges) {
            seen.clear()
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], edge[1])) {
                return edge
            }
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        throw AssertionError()
    }

    fun dfs(graph: Array<ArrayList<Int>>, source: Int, target: Int): Boolean {
        if (!seen.contains(source)) {
            seen.add(source)
            if (source == target) return true
            for (nei in graph[source]) {
                if (dfs(graph, nei, target)) return true
            }
        }
        return false
    }
}
fun main() {
    var s = Solution12()
    val times2 = arrayOf(
            intArrayOf(1,2),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
    );
    println(s.findRedundantConnection(times2))
}