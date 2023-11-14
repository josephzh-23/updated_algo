package Graph.Top_6

import java.util.*
/*
Return the minimum number of steps needed to move the knight to the square [x, y].
 It is guaranteed the answer exists.
 */
fun minKnightMoves2(x: Int, y: Int): Int {
    var steps = 0

    // THis is in case we are given the negative value here
    val x = Math.abs(x)
    val y = Math.abs(y)
    val knightMoveDirs = arrayOf(intArrayOf(1, 2),
            intArrayOf(2, 1), intArrayOf(2, -1), intArrayOf(1, -2),
            intArrayOf(-1, -2), intArrayOf(-2, -1), intArrayOf(-2, 1),
            intArrayOf(-1, 2))

    // Use bfs starting at [0, 0]
    // No need to store dist in the q
    // Set here

    // Seen boolean array here
    val seen:MutableSet<String> = HashSet()
    // Use res to store the distance
    val q: Deque<IntArray> = LinkedList()
    q.addLast(intArrayOf(0, 0))

    while(!q.isEmpty()){
        val cur = q.poll()
        val row = cur[0]
        val col = cur[1]
        var label = "$row + $col"

        var curLevelCount = q.size
        for (i in 0 until curLevelCount) {
            var node = q.poll()
            var curX = node[0]
            var curY = node[1]
            if (curX == x && curY == y) {
                print(steps)
                return steps
            }
            // the other case
            for (dir in knightMoveDirs) {
                val newRow = curX + dir[0]
                val newCol = curY + dir[1]
                var label = "$newRow,$newCol"
                if(!seen.contains(label)){
                    q.add(intArrayOf(newRow, newCol))
                    // check if the q has the value you are
                    // looking for as said then check the other value
                    // here
                    seen.add(label)
                }

                }
        }

        // we will do the following
    }

    // Then do the following and then do this
    return 0
}