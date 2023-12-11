package Graph.Hard

import Dynamic_programming.climbStairsWithKSteps
import Graph.Islands.directions
import Graph.Islands.isInBoundsInt
import java.util.*
import kotlin.math.min


/*
Step 1: start from a house and find all reachable empty lands
since fewer houses than empty lands, so this approach will require less
time here

2.
Create a distance array
 Would be generating partial distance (dist from 1 house to the cur cell)
Would be storing 2 values at each cell position of empty cell
Pair ( total distance sum from all houses to this empty land,
 number of houses that can reach this empty land)

 3. Steps
 For each house cell (grid[i][j] equals 1), start a BFS:
For each empty cell we reach, increase the cell's sum of distances by the steps taken to reach the cell.
For each empty cell we reach, also increment the cell's house counter by 1.

4.
After traversing all houses, get the minimum distance from all empty cells
 which have housesReached equal to totalHouses.

5. If it is possible for all houses to reach a specific empty land cell,
 then return the minimum distance found. Otherwise, return -1.
 */


fun searchMatrix(grid: Array<IntArray>): Int {

    var totalHouses = 0
    var rows = grid.size
    var cols = grid[0].size
    /*  What we are storing here
     Pair (total distance sum from all houses to this empty land,
          number of houses that can reach this empty land)
     */
    val distances = Array(rows) { Array(cols) { IntArray(2) } }


    // Step 1: count all houses and start bfs from each house here
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 1) {

                totalHouses += 1

                bfs(grid, distances, i, j)
            }
        }
    }

    // Step 2: check all empty lands with houses count == total houses and find the min
    // ans

    var minDistance = 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (distances[i][j][1] == 1) {
                minDistance = min(minDistance, distances[i][j][0])
            }
        }
    }

    // If we haven't found a valid cell return -1.
    if (minDistance == Integer.MAX_VALUE) {
        return -1;
    }
    return minDistance;
}

fun bfs(grid: Array<IntArray>, distances: Array<Array<IntArray>>, row: Int, col: Int) {
    var start = intArrayOf(row, col)
    var q: Queue<IntArray> = LinkedList()
    q.add(start)

    var visited = Array(grid.size) { BooleanArray(grid[0].size) }
    visited[row][col] = true
    // We know the starting pt right here

    var steps = 0
    visited[start[0]][start[1]] = true
    while (!q.isEmpty()) {
        for (i in q.size downTo 0) {
            // Since this will happen on a
            var node = q.poll()
            var x = node[0];
            var y = node[1]

            // Increment the count of houses and the steps
            if (grid[x][y] == 0) {
                distances[row][col][0] += steps
                distances[row][col][1] += 1
            }
            // YOu need to print the node at that point


            directions.forEach { dir ->
                var dx = x + dir[0]
                var dy = y + dir[1]
                if (isInBoundsInt(grid, dx, dy)) {
                    if (!visited[dx][dy] && grid[dx][dy] == 0) {
                        println("removed node is ${grid[dx][dy]} ")
                        visited[dx][dy] = true
                        q.offer(intArrayOf(dx, dy))
                    }
                }
            }
        }
        steps++
    }
}

