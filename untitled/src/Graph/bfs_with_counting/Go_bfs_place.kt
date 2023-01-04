package Graph.bfs_with_counting

import java.util.*

/*

https://leetcode.com/discuss/interview-question/391195/google-onsite-go-game
1. Here given the new out of bound error

2. Given a new black stone to put on empty spot
 */

// For this problem use BFS would be for good
/*
The graph here is
1  1  1   1
1  1  1   1
1  0  0   1
1  1  1   1
 */
var w = 'w'
var b = 'b'
var e = 'e'
var goBoard = arrayOf(charArrayOf(e, e, e, e, b, b, b),
                    charArrayOf(e, e, e, b,  w, w, b),
                     charArrayOf(e, e, e, e, b, e, b),
                    charArrayOf(e, e, e, e, e, e, e))

/*
Output: 1
Explanation: If you place a black stone on
(2, 5) then you capture 1 white stone from the enemy.
 */
val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))


// r and c where you palce the stone
fun solveGo(board: Array<CharArray>, r: Int, c:Int):Int{

    // and to work on this problem here
    val m = board.size
    val n = board[0].size
    val visited = Array(m) { BooleanArray(n) }

    // Mark spot as visited
    visited[r][c] = true

    var count = 0
    for (dir in directions) {
        count += bfs(board, visited, r + dir[0], c + dir[1])
        println(" # of times comes here")
    }
    return count
}
fun bfs(board: Array<CharArray>,visited: Array<BooleanArray>,  r: Int, c:Int):Int{

    var count = 0
    // valid is needed to check if you can capture sth
    var surrounded = true
    // Move in 4 directions
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    val q: Queue<IntArray> = LinkedList()

    q.offer(intArrayOf(r, c))
    while(!q.isEmpty()){
        var node = q.poll()
        var x= node[0]; var y = node[1]
        if(isOutOfBounds(board, x, y) || visited[x][y] ||
                board[x][y] == 'b')continue

        // This means you have run into an empty stone
        // spot so no count returned
        if (board[x][y] == 'e') {
            surrounded = false
        } else {
            // Here a white stone is encountered
            visited[x][y] = true

            // If white encountered then we need to basically do another traverseal
            // But add a 1 count for each white encountered
            directions.forEach { dir ->
                q.offer(intArrayOf(x + dir[0], y + dir[1]))
            }
            count++
        }
    }

    return if (surrounded) count else 0
}
fun isOutOfBounds( board: Array<CharArray>, x: Int, y:Int): Boolean {
    return (x< 0|| y< 0 || x> board.size - 1|| y> board[0].size -1)
}

fun main() {
    /*
    Output: 1
    Explanation: If you place a black stone on
    (2, 5) then you capture 1 white stone from the enemy.
     */
    println(solveGo(goBoard, 2, 5))
}