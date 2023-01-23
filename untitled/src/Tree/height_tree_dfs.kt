package Tree


import TreeNode
import print


/*
Please see notes, need to use a post order approach here
 */
internal class Solution12 {

    // Count the number of pairs here in the graph as said
    var height = 0
    fun count(root: TreeNode?, distance: Int): Int {
         helper(root, distance)
        return height
    }

    fun helper(root: TreeNode?, distance: Int) {
        val l: MutableList<Int> = ArrayList()
        if (root == null) return

        helper(root.left, distance)
        helper(root.right, distance)
        // When
        if(root.left!=null &&root.right!=null ) {
            height++
        }

        return
    }
}

fun main() {
    var s = Solution12()
    val r = TreeNode(1)
    r.left = TreeNode(2)
    r.right = TreeNode(3)
    r.left!!.left = TreeNode(4)
    r.left!!.right = TreeNode(5)
    r.right!!.left = TreeNode(6)
    r.right!!.right = TreeNode(7)
    s.count(r, 3).print()

//    val r = TreeNode(1)
//    r.left = TreeNode(2)
//    r.right = TreeNode(3)
//    r.left!!.right = TreeNode(4)
//    s.countPairs(r, 3).print()
}