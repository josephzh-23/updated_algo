package Graph.Top_6

import java.util.*


// The new problem here

// A knight with 8 moves here
/*
0. Make sure data structure right first
1. Check if col at x, y
2. Need a set as said, need newCol and newRow
3. Q with # of moves with the knight (no need for dijkstra, minQ, since
you already have it )

4. Need to iterate thru each level of the q if not storing move int the q
 */


fun minKnightMoves(x: Int, y: Int): Int {

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
    var steps = 0
    while (!q.isEmpty()) {

        /*
        0, 1
         */
        var curLevelCount = q.size
        for (i in 0 until curLevelCount) {
            var node = q.poll()
            var curX = node[0]
            var curY = node[1]
            if (curX == x && curY == y) {
                print(steps)
                return steps
            }

            // Search in all dir of node
            for (dir in knightMoveDirs) {
                val newRow = curX + dir[0]
                val newCol = curY + dir[1]
                println(newRow + newCol)

                val s = "$newRow,$newCol"
                if (!seen.contains(s)) {
                    q.add(intArrayOf(newRow, newCol))
                    seen.add(s)
                }
            }
        }
        steps++


    }
    print(steps)
    return steps
}

fun main() {
    val x = 2; val y = 1;
    minKnightMoves(2, 1)
}







