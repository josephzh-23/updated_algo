package Util

class `2d_set` {
    var grid = arrayOf(intArrayOf(0,0,1,0),
            intArrayOf(0,0,0,0,),
            intArrayOf(0,1,1,0))

    var seen =   Array(grid.size) { BooleanArray(grid[0].size) }

}