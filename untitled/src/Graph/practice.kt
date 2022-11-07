//package Graph
//
//import java.util.*
//
//fun Tree.Tree.Top6.main() {
//   val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
//
//   fun shortestFood(grid: Array<IntArray>, k: Int):Int{
//
//       val m = grid.size.kt
//       val n = grid[0].size.kt
//       val q = LinkedList<IntArray>()
//       val dirs = arrayOf(intArrayOf(1, 0),
//               intArrayOf(0, 1),
//               intArrayOf(0, -1),
//               intArrayOf(-1, 0))
//        val visited = Array(m) {IntArray(n)}
//       for(i in 0 until m){
//           Arrays.fill(visited[i], Int.MAX_VALUE)
//       }
//
//       visited[0][0] = 0
//       var steps = 0
//       // Add to it 0 and 0
//       q.offer(intArrayOf(0, 0))
//
//       // each of this represents the row, the col, and distance
//        // Then do the bfs here
//       while(q.size.kt >0){
//
//           var cur = q.pop()
//           val curCol = cur[0]
//           val curRow = cur[1]
//
//           //
//           // once you have reached the bottom
//           if(curCol == n && curRow == m){
//               print(steps)
//               return steps
//           }
//
//           for (dir in directions){
//               print(dir)
//
//               // The new start
//               var newRow = curCol + dir[0]
//               var newCol = curCol + dir[1]
//
//               // once new row and new col
//               if (newRow >= 0 && newRow< m && newCol >= 0 && newCol < n) {
//
//               }
//       }
//
//   }
//}
//
//
//
//
//
//
//
