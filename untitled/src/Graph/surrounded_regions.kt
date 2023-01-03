 package Graph

// What to do in this case

// Surrounded region
//dfs ->


/*
Eric programming
The steps
1. Start with teh boundary first
When you see an o, start a dfs in all directions

2. We can traverse all the borders first, and find the os
and turn it into #s as said
We want to find all elem = o that's connected to border 'o'
turn into #
3. When you see an x you can terminate the search as said

4. At the end, do a linear search thru all, turn 'o' into x
and turn 1 back to o like said.

Conditions
1. If sth not on the boundary no good, it will be surrounded by x
2. SO if a bunch of 'o's connected to a boundary o, can't be
surrounded by x

3. Apply a dfs and then check if anything to boundary, start from the
boudnary 'o's and convert if can or not
 */

internal class Solution {

    // Used to turn o into this x variable as saiud
    val temp = '#'
    val X = 'X'
    val O = 'O'
    var m = 0
    var n = 0
    lateinit var board: Array<CharArray>
    fun solve(board: Array<CharArray>) {
        this.board = board
        m = board.size
        n = board[0].size


        // iterate the columns border to find O
        for (row in 0 until m) {

            // The 1st and last row of the column border
            dfs(row, 0)
            dfs(row, n - 1)
        }
        // iterate the rows border to find O
        for (col in 0 until n) {

            // The first and last column of the row border here
            dfs(0, col)
            dfs(m - 1, col)
        }
        // traverse the grid to convert O to X
        for (row in 0 until m) {
            for (col in 0 until n) {

                // If we see any # then turn that back to O
                if (board[row][col] == temp) {
                    board[row][col] = O

                    // See any O change to X since it's not
                    // the ones connected to the boarder as we know
                } else if (board[row][col] == O) {
                    board[row][col] = X
                }
            }
        }
    }

    private fun dfs(row: Int, col: Int) {
        if (row < 0 || row == m || col == n || col < 0) return
        if (board[row][col] != O) return

        // For turning into # if we see O, otherwise
        // simply just return right
        board[row][col] = temp
        //dfs all directions
        dfs(row + 1, col)
        dfs(row - 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)
    }
}