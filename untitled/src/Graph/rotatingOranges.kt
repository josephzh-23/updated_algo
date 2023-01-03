package Graph

import Graph.bfs_with_return.directions
import java.util.*

fun orangesRotting(grid: Array<IntArray>): Int {


    // perform bfs on this

    // given a start point here
//    var start = intArrayOf(1,1)
    // 1 and 1 are the starting point for this
    var visited =Array(matrix.size){BooleanArray(matrix[0].size)}
    var start = intArrayOf(0, 0)
    var q: Queue<IntArray> = LinkedList()
    q.add(start)

    // We know the starting pt right here

    var count = 0

    visited[start[0]][start[1]] = true
    while(!q.isEmpty()){
        var node = q.poll()
        var x= node[0]; var y = node[1]
        // YOu need to print the node at that point

        var allZeros = false
        directions.forEach { dir ->
            var dx = x + dir[0]
            var dy = y + dir[1]
            if (isInBoundsInt(matrix, dx, dy)  ) {

                if(checkIfBoundary(matrix, dx, dy)&& matrix[dx][dy] ==1){

                }
                if(!visited[dx][dy]) {
                    println("removed node is ${matrix[dx][dy]} ")
                    visited[dx][dy] = true
                    q.offer(intArrayOf(dx, dy))
                }
            }
        }
    }
//    return true
}

fun checkIfBoundary(a: Array<IntArray>, x: Int,
                    y: Int): Boolean {

    // Firt row
    if ((x == 0) || (x == a.size - 1) || (y == 0)
            || (y == a[0].size - 1)) {
        return true
    }
    return false

}