package tricks

fun setZeroes(matrix: Array<IntArray>) {

    // This checks if there is any 0 in the first column
    var firstCol = false
    // This checks if there is any 1 in the first row
    var firstRow = false

    //Check for anything in 1st row of every column
    // [0][1]       [0][2]
    for (i in matrix[0].indices) {
        if (matrix[0][i] == 0) {
            firstRow = true
            break
        }
    }
}
