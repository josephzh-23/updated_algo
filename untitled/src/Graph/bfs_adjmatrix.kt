package Graph

import java.util.*


// Using the bfs adjacency matrix here
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    // given a start point here
    var start =
    var visited = BooleanArray(matrix.size)
    Arrays.fill(visited, false)

    var q: Queue<IntArray> = LinkedList()
    q.add(intArrayOf)

    visited[start] = true
    while(!q.isEmpty()){
        var node = q.poll()
        println("removed node is")
        q.remove(q.get(0))
    }

}

// This makes sure no array out of bound exception here
fun isOutOfBounds( board: Array<CharArray>, x: Int, y:Int): Boolean {
    return (x< 0|| y< 0 || x> board.size - 1|| y> board[0].size -1)
}








