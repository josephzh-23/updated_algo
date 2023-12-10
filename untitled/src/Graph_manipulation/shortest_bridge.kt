package Graph_manipulation

import Graph.Basics.isInBoundsInt
import Graph.Islands.directions
import java.util.*

// Make sure this is working as intended
fun main() {

    var grid = arrayOf(intArrayOf(0,1, 0),
            intArrayOf(0,0, 0),
            intArrayOf(0,0, 1))
    var s = Solution(grid)
    print("answer is ${s.searchMatrix(grid)}")
}

class Solution(grid: Array<IntArray>) {

    var rows = grid.size
    var cols = grid[0].size
    var queue = LinkedList<IntArray>()

    // Using a hashset here is quite useful
    var visited = Array(grid.size) { BooleanArray(grid[0].size) }
    var grid = grid


    // Find any island and mark its cells as 2 and set starting positions
    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c]!== 1) {
            return
        }
        grid[r][c] = 2
        queue.offer(intArrayOf(r, c))
        visited[r][c] = true
        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
    }


    fun searchMatrix(matrix: Array<IntArray>): Int {


        // use the dfs above to find the starting point first
        var found = false
        for (r in 0 until rows) {
            if (found) break
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    dfs(r, c)
                    found = true
                    break
                }
            }
        }
        // Perform a bfs starting from the cell marked as 2

        var distance = 0
        while (!queue.isEmpty()) {
            // YOu need to print the node at that point

            // Need to traverse each level like in rotting oranges as said before
            for (level in 0 until queue.size) {
                var node = queue.poll()
                var x = node[0];
                var y = node[1]
                directions.forEach { dir ->
                    var dx = x + dir[0]
                    var dy = y + dir[1]
                    if (isInBoundsInt(matrix, dx, dy)) {
                        if (!visited[dx][dy]) {
                            println("removed node is ${matrix[dx][dy]} ")


                            if (grid[dx][dy] == 1) {
                                return distance
                            }

                            visited[dx][dy] = true
                            queue.offer(intArrayOf(dx, dy))
                        }
                    }
                }
            }
            distance++
        }
        return -1
    }
}