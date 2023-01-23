//import java.util.*
//
//
//fun Tree.Hard.main() {
//    minKnightMoves(2, 1)
//}
//
//fun minKnightMoves(x: Int, y: Int) {
//
//    // THis is in case we are given the negative value here
//    val x = Math.abs(x)
//    val y = Math.abs(y)
//    var visited = Array(100) { BooleanArray(100) }
//
//    var start = intArrayOf(0, 0)
//    val knightMoveDirs = arrayOf(intArrayOf(1, 2),
//            intArrayOf(2, 1), intArrayOf(2, -1), intArrayOf(1, -2),
//            intArrayOf(-1, -2), intArrayOf(-2, -1), intArrayOf(-2, 1),
//            intArrayOf(-1, 2))
//    var q: Queue<IntArray> = LinkedList()
//    q.add(start)
//
//    // We know the starting pt right here
//
//    var count = 0
//
//    visited[start[0]][start[1]] = true
//    while (!q.isEmpty()) {
//
//        var curSize = q.size
//        for (i in 0 until curSize) {
//            var node = q.poll()
//            var dx = node[0];
//            var dy = node[1]
//            // YOu need to print the node at that point
//            if (dx == x && dy == y) {
//                println(count)
//            }
//            knightMoveDirs.forEach { dir ->
//                var dx = x + dir[0]
//                var dy = y + dir[1]
//                if (!visited[dx][dy]) {
//
//                    visited[dx][dy] = true
//                    q.offer(intArrayOf(dx, dy))
//
//                }
//            }
//        }
//        count++
//    }
//}