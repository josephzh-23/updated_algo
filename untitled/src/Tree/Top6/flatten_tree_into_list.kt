package Tree.Top6

import TreeNode

/*
        1
   2      5
  3  4      6

 Steps
   Take tempL, tempR to store left and right
   r.left = null
   flatten(left)    flatten(right)
 */

internal class Solution {
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val tempLeft = root.left
        val tempRight = root.right
        root.left = null
        flatten(tempLeft)
        flatten(tempRight)
        root.right = tempLeft
        var current: TreeNode? = root

        // get to the last node
        while (current?.right != null) current = current.right
        current?.right = tempRight
    }
}