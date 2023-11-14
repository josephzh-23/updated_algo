package Graph.Advanced

import java.util.*


/*

Find the empty cell with shortest distance to all houses

Find shortest total distance to all hourses from each empty land celll

2. If can't reach all house from empty cell, not a valid cell here
3. Any cell visited during BFS are also obstacles

4. If cell ! reach all the houses, set every visited empty land to 2
so that no more BFS from that spot here

5. Need to udpate the min disatnce here

 */

// O (n ^2 )
private fun bfs(grid: Array<IntArray>, row: Int, col: Int, totalHouses: Int): Int {
    // Next four directions.
    var row = row
    var col = col
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    val rows = grid.size
    val cols = grid[0].size

    // The total distance here
    var distanceSum = 0
    var housesReached = 0

    // Queue to do a bfs, starting from (row, col) cell.
    val q: Queue<IntArray> = LinkedList()
    q.offer(intArrayOf(row, col))

    // Keep track of visited cells.
    val vis = Array(rows) { BooleanArray(cols) }
    vis[row][col] = true
    var steps = 0
    while (!q.isEmpty() && housesReached != totalHouses) {
        for (i in q.size downTo 1) {
            val curr = q.poll()
            row = curr[0]
            col = curr[1]

            // If this cell is a house, then add the distance from source to this cell
            // and we go past from this cell.
            if (grid[row][col] == 1) {
                distanceSum += steps
                housesReached++
                continue
            }

            // This cell was empty cell, hence traverse the next cells which is not a blockage.
            for (dir in dirs) {
                val nextRow = row + dir[0]
                val nextCol = col + dir[1]
                if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                    if (!vis[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                        vis[nextRow][nextCol] = true
                        q.offer(intArrayOf(nextRow, nextCol))
                    }
                }
            }
        }

        // After traversing one level of cells, increment the steps by 1 to reach to next level.
        steps++
    }

    // If we did not reach all houses, then any cell visited also cannot reach all houses.
    // Set all cells visted to 2 so we do not check them again and return MAX_VALUE.
    if (housesReached != totalHouses) {
        row = 0
        while (row < rows) {
            col = 0
            while (col < cols) {

                // Visited cell mark it as 2
                if (grid[row][col] == 0 && vis[row][col]) {
                    grid[row][col] = 2
                }
                col++
            }
            row++
        }
        return Int.MAX_VALUE
    }

    // If we have reached all houses then return the total distance calculated.
    return distanceSum
}

fun shortestDistance(grid: Array<IntArray>): Int {
    var minDistance = Int.MAX_VALUE
    val rows = grid.size
    val cols = grid[0].size
    var totalHouses = 0
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (grid[row][col] == 1) {
                totalHouses++
            }
        }
    }

    // Find the min distance sum for each empty cell.
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (grid[row][col] == 0) {
                minDistance = Math.min(minDistance, bfs(grid, row, col, totalHouses))
            }
        }
    }

    // If it is impossible to reach all houses from any empty cell, then return -1.
    return if (minDistance == Int.MAX_VALUE) {
        -1
    } else minDistance
}






