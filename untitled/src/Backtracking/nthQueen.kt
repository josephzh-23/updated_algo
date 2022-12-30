package Backtracking

import java.util.*


internal class Solution {
    var res: MutableList<List<String>> = LinkedList()
    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { CharArray(n) }
        for (cs in board) {
            Arrays.fill(cs, '.')
        }
        helper(board, 0, 0, n)
        return res
    }

    private fun helper(board: Array<CharArray>, row: Int, col: Int, n: Int) {
        // Column out of bound
        var row = row
        var col = col
        var n = n
        if (col == board[0].size) {
            col = 0
            row++
        }
        // n is 0 then add to the res
        if (n == 0) {
            res.add(toString(board))
            return
        }
        // Row out of bound
        if (row == board.size) return

        // Place queen here if valid
        if (isValid(board, row, col)) {
            board[row][col] = 'Q'
            n--
            helper(board, row, col + 1, n)
            // backtrack unchoose the option
            board[row][col] = '.'
            n++
        }

        // Skip this cell, we place a '.'
        helper(board, row, col + 1, n)
    }

    private fun toString(board: Array<CharArray>): List<String> {
        val list: MutableList<String> = LinkedList()
        var str: StringBuilder
        for (cs in board) {
            str = StringBuilder()
            for (cur in cs) {
                str.append(cur)
            }
            list.add(str.toString())
        }
        return list
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int): Boolean {

        val N = board.size

        // TOP AND DOWN
        // Here iterating top and down see if anything not
        // emtpy
        for (i in 0 until N) {
            if (board[i][col] != '.') return false
            if (board[row][i] != '.') return false
        }
        // Top left + top right + down left + down right
        var i = row
        var j = col

        // this is when you go in the diagonal
        // upper left position so go diagnoal here
        while (0 <= i && 0 <= j) {
            // if this not empty
            if (board[i][j] != '.') return false
            i--
            j--
        }
        // Top right
        i = row
        j = col
        while (0 <= i && j < N) {
            if (board[i][j] != '.') return false
            i--
            j++
        }
        // Down Right
        i = row
        j = col
        while (i < N && j < N) {
            if (board[i][j] != '.') return false
            i++
            j++
        }

        // Down left position in leetcode
        i = row
        j = col
        while (i < N && 0 <= j) {
            if (board[i][j] != '.') return false
            i++
            j--
        }
        return true
    }
}