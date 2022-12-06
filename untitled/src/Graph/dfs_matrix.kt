package Graph


var grid = arrayOf(intArrayOf(0,0,1,0),
                intArrayOf(0,0,0,0,),
                intArrayOf(0,1,1,0))

var seen = Array(grid.size) { BooleanArray(grid[0].size) }


fun main(){

    dfsMatrix()
}

fun dfsMatrix(){
    val nr = grid.size
    val nc = grid[0].size
    for (r in 0 until nr) {
        for (c in 0 until nc) {
            dfs(grid, r, c)
        }
    }
}

fun dfs(grid: Array<IntArray>, r: Int, c: Int) {

    // visited already
    if (r < 0 || c < 0 || r >= grid.size || c >=
            grid[0].size || seen[r][c]) {
        return
    }
    // else mark as visited
    seen[r][c] = true
    println(grid[r][c])
    dfs(grid, r - 1, c)
    dfs(grid, r + 1, c)
    dfs(grid, r, c - 1)
    dfs(grid, r, c + 1)

}