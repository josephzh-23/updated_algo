package Tree.Basic

import java.util.*
import kotlin.collections.ArrayList


fun findMaxOnEachRow(r: TreeNode?): List<Int> {

    var results = ArrayList<Int>()
    if (r == null) {
        return results
    }


    var q = LinkedList<TreeNode>()
    r.let {
        q.add(it)
    }
    while (!q.isEmpty()) {
        val curLevel = ArrayList<Int>()
        // -inf   3
        var curMax = Integer.MIN_VALUE
        // The num of nodes in cur level
        for (i in 0 until q.size) {
            val cur = q.remove()
            curMax = Math.max(curMax, cur.value)
            curLevel.add(cur.value)
            cur.left?.let {
                q.add(it)
            }
            cur.right?.let {
                q.add(it)
            }
        }
        results.add(curMax)

    }
    results.forEach {
        println(it)
    }
    return results
}


fun main() {
    var root = TreeNode(3)
    root.left = TreeNode(4)
    root.right = TreeNode(5)
    root.left!!.left = TreeNode(6)
    root.left!!.right = TreeNode(7)
    root.right!!.left = TreeNode(8)
    root.right!!.right = TreeNode(9)
    findMaxOnEachRow(root)
}
