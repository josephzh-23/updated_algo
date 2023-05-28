fun main() {
    var arr = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0)
    )
//    var arr = arrayOf(intArrayOf(1, 1, 1),
//            intArrayOf(1, 1, 1),
//            intArrayOf(1, 1, 1))
    findPath2(arr, 3)
}

fun findPath2(m: Array<IntArray>, n: Int): ArrayList<String> {
    val ans = ArrayList<String>()
    val visited = Array(n) { BooleanArray(n) }
    val number = findMorePath(0, 0, m, visited)
    println(number)
    return ans
}

fun findMorePath(i: Int, j: Int, arr: Array<IntArray>, visited: Array<BooleanArray>): Int {
    var m = arr.size
    var n = arr[0].size
    if (i < m && j < n && i >= 0 && j >= 0 && visited[i][j] == false &&
        arr[i][j] != 1
    ) {
        // we have found 1 way
        if (i == m - 1 && j == n - 1) {
            return 1
        }
        // visited already
        visited[i][j] = true
        val totalPath = findMorePath(i + 1, j, arr, visited) +
                findMorePath(i, j + 1, arr, visited)

        // Need to backtrack after finding 1 path
        visited[i][j] = false

        return totalPath
    } else {
        return 0
    }
}