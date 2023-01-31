import java.util.*

/*
Basically there r 2 colors here
blue means 1        red means -1        no color = 0
This prob can be done using the s solution here
 */
fun main() {
    var s = arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 2),
            intArrayOf(0, 1, 3), intArrayOf(0, 2))

    isBipartite(s)
}


// What would this look like?
//[1, 2 , 3]  then this becomes
fun isBipartite(g: Array<IntArray>): Boolean {
    val colors = IntArray(g.size)
    for (i in g.indices) if (colors[i] == 0) {
        val q: Queue<Int> = LinkedList()


        q.add(i)

        // and then here using the code for the other one
        colors[i] = 1
        while (!q.isEmpty()) {
            val node = q.poll()

            println()

            //basically this becomes
            // Say if node == 0
            // then g[0] = 1, 2, 3
            for (adjacent in g[node]) if (colors[adjacent] == colors[node])
                return false else if (colors[adjacent] == 0) {
                q.add(adjacent)
                colors[adjacent] = -colors[node]
            }
        }
    }
    return true
}