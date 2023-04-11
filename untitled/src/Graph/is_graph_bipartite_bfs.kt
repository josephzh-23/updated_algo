import java.util.*


// If using this and then we are given the following code
fun main() {
    var arr = arrayOf(
        intArrayOf(1, 2, 3), intArrayOf(0, 2),
        intArrayOf(0, 1, 3), intArrayOf(0, 2)
    )

    isBipartite(arr).print()
}
// If using this we are given, we can try to do the dfs of this approach
// and then

fun isBipartite(g: Array<IntArray>): Boolean {
    val colors = IntArray(g.size)
    for (i in g.indices) if (colors[i] == 0) {
        val q: Queue<Int> = LinkedList()
        q.add(i)
        colors[i] = 1
        while (!q.isEmpty()) {

            val node = q.poll()

            // Here if node = 0     [1, 2, 3]
            // Since 0 will have node 1, 2, 3 here  they are connected by any case

            for (adjacent in g[node]) {
                println(adjacent)
                if (colors[adjacent] == colors[node]) return false
                // So basically here there is no color yet
                // So we do sth for it and then change it to sth else

                else if (colors[adjacent] == 0) {
                    q.add(adjacent)
                    // The opposite of the other one
                    colors[adjacent] = -colors[node]
                }
            }
        }
    }
    return true
}