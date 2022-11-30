package Graph.Top_6


/*
1. things to watch out fo the array out of bound index error here
2.
 */
val w = 'w'
val b ='b'
var grid = arrayOf(charArrayOf('w', 'b', 'w', 'b', 'w'),
        charArrayOf('b', 'b', 'b', 'b', 'b'),
        charArrayOf('w', 'b', 'b', 'b', 'b'),
        charArrayOf('w', 'b', 'b', 'b', 'b'))




fun main() {
    // and to work on this problem here
    val x= 0
    val y = 4

    val curColor = grid[x][y]
    val row = grid.size
    val col = grid[0].size

    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    for(dir in directions){
        val newRow = x + dir[0]
        val newCol = y + dir[1]
        // There is the arrayout of bound index exception here
        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
            println("new row and col is $newRow and $newCol")
            println("within bound ")
        }else{
            println("new row and col is $newRow and $newCol")
            println("out of bound  ")
        }
    }

}