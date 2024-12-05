package Graph

import Graph.Islands.directions
import java.util.*


/*

And to get this thing started here #1 thing is

This is very similar to rotten oranges
 */


var matrix3 = arrayOf(
    intArrayOf(0, 0, 0),
    intArrayOf(1, 1, 0),
    intArrayOf(1, 1, 0)
);



var dirs8 = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1), intArrayOf(0, -1),
    intArrayOf(0, 1), intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1))

// Using the bfs adjacency matrix here
// THis one will work for sure 100% as said
fun searchMatrix2(grid: Array<IntArray>): Int {
    if (grid[0][0] ==1 ){return -1}


    var visited = Array(grid.size) { BooleanArray(grid[0].size) }
    var start = intArrayOf(0, 0)
    var q: Queue<IntArray> = LinkedList()
    q.add(start)
    var length = 1
    var n = grid.size

    visited[0][0] = true
    while (!q.isEmpty()) {

        var count = q.size

        for(i in 0..count) {
            var node = q.poll()
            var x = node[0];
            var y = node[1];

            directions.forEach { dir ->
                var dx = x + dir[0]
                var dy = y + dir[1]

                if (x == n - 1 && y == n - 1) {
                    return length
                }
                    /*

                    Get neighbors will get you all the neighbors here
                    in the 8 directions
                     */


                    getNeighbors(x, y, n).forEach {
                        var (nx, ny) = it

                        if (grid[nx][ny] == 0 && !visited[nx][ny]) {

                            q.add(intArrayOf(nx, ny))
                            visited[nx][ny] = true
                        }


                    }
            }
        }
        length++

    }

//    println("the count is$count")

    return -1
}

fun getNeighbors(x:Int, y: Int, n: Int):ArrayList<ArrayList<Int>>{

    var neighbors = ArrayList<ArrayList<Int>>()

    directions.forEach{
        var (dx, dy ) = Pair(x + it[0], y + it[1])
        if((0 <= dx && dx < n)&& (0 <= dy && dy< n)){
            neighbors.add(arrayListOf(dx, dy))

        }
    }
    return neighbors
}

fun main() {

    // and then this gives you the answer here
    println(searchMatrix2(matrix3))
//    println("$")
}
