package Tree

import java.util.*
import kotlin.collections.ArrayList

fun printBottomView(r: TreeNode) {

    var results = ArrayList<List<Int>>()
    if (r == null) {
        return
    }

    var q = LinkedList<TreeNode>()
    r?.let {
        q.add(it)
    }
    while (!q.isEmpty()) {
        val curLevel = ArrayList<Int>()
        for (i in 0 until q.size) {
            val cur = q.remove()
            curLevel.add(cur.value)
            cur.left?.let {
                q.add(it)
            }
            cur.right?.let {
                q.add(it)
            }
        }
        results.add(curLevel.toList())

    }
    results.forEach {
        println(it)
    }

}