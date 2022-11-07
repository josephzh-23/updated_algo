package Tree

import Tree.Top6.isLeaf

fun addRightBoundary2(root: TreeNode, res: ArrayList<Int>) {

    var cur: TreeNode = root.right
    val tmp = ArrayList<Int>()
    while (cur != null) {
        if (isLeaf(cur) == false) tmp.add(cur.value)
        cur = if (cur.right != null) cur.right else cur.left
    }
//    var

    // Add the temp result to the right

}