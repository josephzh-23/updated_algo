package Graph

/*

What we can do
1. Every time see gate run a dfs from it and then this
2. This will reach all the cells in the range
3. Pass a count in the dfs 1 and make sure it has the shortest distance
 */


import Graph.Top_6.directions
import Graph.Top_6.isOutofBounds
import java.util.*

var matrix2 =arrayOf(
        intArrayOf(214, -1, 0, 214),
        intArrayOf(214, 214, 214, -1),
        intArrayOf(214, -1, 214, -1),
        intArrayOf(0, -1, 214,214)
);

/*
We will start the distance from the gate first
1. So when we see a gate we will start this
 */
fun wallGates(grid: Array<IntArray>): Boolean {
    // given a start point here
//    var start = intArrayOf(1,1)
    var row = grid.size
    var col = grid[0].size
    // 1 and 1 are the starting point for this
    var visited =Array(matrix.size){BooleanArray(matrix[0].size)}
    var start = intArrayOf(0, 0)
    var q: Queue<IntArray> = LinkedList()
    q.add(start)

    var count = 0

    // look for starting pt
    for( i in 0 until row){
        for (j in 0 until col ){

            // That means a gate
            if(grid[i][j] ==0) {
                q.add(intArrayOf(row, col, 0))
            }
        }
    }
    while(!q.isEmpty()){

        val cur= q.poll()
        val row = cur[0]
        val col = cur[1]
        val dist = 0
        if(cur.size> 2) {
            val dist = cur[2]

        }
        // Update the distance
        if(dist <= grid[row][col]){
            // update the distance since we want shortest
            grid[row][col] == dist
        }
        directions.forEach { dir->
            var newRow = row + dir[0]
            var newCol = col + dir[1]
            if (isInBounds(matrix, newRow, newCol)&& grid[newRow][newCol] != -1) {
                q.add(intArrayOf( newRow, newCol, dist +1))
            }
        }
    }
    return true
}
fun main() {
    wallGates(matrix2)

}

// This makes sure no array out of bound exception here






