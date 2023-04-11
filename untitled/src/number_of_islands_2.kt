internal class UnionFind2(size: Int) {
    var parent: IntArray
    var rank: IntArray

    // The count here used to fidn the
    var count: Int

    init {
        parent = IntArray(size)
        rank = IntArray(size)
        for (i in 0 until size) parent[i] = -1
        count = 0
    }

    fun addLand(x: Int) {
        if (parent[x] >= 0) return
        parent[x] = x
        count++
    }

    fun isLand(x: Int): Boolean {
        return if (parent[x] >= 0) {
            true
        } else {
            false
        }
    }

    fun numberOfIslands(): Int {
        return count
    }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val xset = find(x)
        val yset = find(y)
        if (xset == yset) {
            return
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset
        } else {
            parent[yset] = xset
            rank[xset]++
        }
        count--
    }
}

internal class Solution {
    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
        val x = intArrayOf(-1, 1, 0, 0)
        val y = intArrayOf(0, 0, -1, 1)
        val dsu = UnionFind2(m * n)
        val answer: MutableList<Int> = ArrayList()
        for (position in positions) {
            val landPosition = position[0] * n + position[1]
            dsu.addLand(landPosition)
            for (i in 0..3) {
                val neighborX = position[0] + x[i]
                val neighborY = position[1] + y[i]
                val neighborPosition = neighborX * n + neighborY
                // If neighborX and neighborY correspond to a point in the grid and there is a
                // land at that point, then merge it with the current land.
                if (neighborX >= 0 && neighborX < m && neighborY >= 0 && neighborY < n &&
                        dsu.isLand(neighborPosition)) {
                    dsu.union(landPosition, neighborPosition)
                }
            }
            answer.add(dsu.numberOfIslands())
        }
        return answer
    }
}