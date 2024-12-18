package Tree

import Hard.hasPathSum
import Tree.Basic.TreeNode
import Util.printList
import java.util.*


/*

Using dfs here
1. Check if root is a leaf or not,

Why do we do a pre-order traversal here?

Because it's from left to right


2. Then check the node, If no left child is present, it chooses the right child. Nodes verified as non-leaves are appended to the result list.

3. Use a fxn addLeaves to add leaf node
    to the result list

4.
 */



class Solution {
    fun isLeaf(t: TreeNode?): Boolean {
        return t!!.left == null && t.right == null
    }
    /*
    If it's a leaf node then add it

    1. Otherwise use the right or the left and keep calling the below

    2.
     */
    fun addLeaves(res: MutableList<Int?>, root: TreeNode?) {
        if (isLeaf(root)) {
            res.add(root!!.value)
        } else {
            if (root!!.left != null) {
                addLeaves(res, root.left)
            }
            if (root.right != null) {
                addLeaves(res, root.right)
            }
        }
    }

    fun boundaryOfBinaryTree(root: TreeNode?): List<Int?> {
        val res = ArrayList<Int?>()
        if (root == null) {
            return res
        }

        if (!isLeaf(root)) {
            res.add(root.value)
        }


        var t = root.left
        /*

        Left boundary:
        We first traverse on the left section of the tree here, and the node to the res
    At any point if we don't have a left child anymore,
but its right child exists, we put the right child in the res and continue the process.

         */
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.value)
            }
            t = if (t.left != null) {
                t.left
            } else {
                t.right
            }
        }
        addLeaves(res, root)

//        println("the res here are"+ printList(res))
        /*

        At this point this will have all the leaf nodes or nodes on the left sides
        1, 2, 4, 7, 8, 9, 10
         */

        /*

        Right Boundary:
         We perform the same process as the left boundary. But, this time, we traverse towards the right. If the right child doesn't exist, we move towards the left child. Also, instead of putting the traversed nodes in the res array, we push them over a stack during the traversal. After the complete traversal is done, we pop the element from over the stack and append them to the res array. The following animation depicts the process.

         so this would give us 6 and 3
         */
        printList(res)
        val s: Stack<Int> = Stack()
        t = root.right
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.value)
            }
            t = if (t.right != null) {
                t.right
            } else {
                t.left
            }
        }
        while (!s.empty()) {
            res.add(s.pop())
        }

        println("res here"+ printList(res))
        return res
    }
}



fun main() {
    var r = TreeNode(1)
    r.left = TreeNode(2)
    r.right = TreeNode(3)
    r.left!!.left = TreeNode(4)
    r.left!!.right = TreeNode(5)

    r.left!!.right!!.right = TreeNode(8)
    r.left!!.right!!.left = TreeNode(7)

    r.right!!.left = TreeNode(6)
    r.right!!.left!!.left = TreeNode(9)
    r.right!!.left!!.right = TreeNode(10)

    // You
    var c = Solution()
    c.boundaryOfBinaryTree(r)
}





