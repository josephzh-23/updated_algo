package Tree.Top6

import Tree.TreeNode
import java.util.*

// Make sure it's sorted using traversal

// Will be in order
fun main() {

    fun validateBSTIter() {
        var stack = Stack<TreeNode>()
        // Make you traverse all the way to the left
        while (root != null) {
            stack.push(root);
            root = root.left
        }

        // This is parent value
        root = stack.pop()
        if(root.val <= leftChildVal) return false
        leftChildVal = root.value
        root = root.right

    }

    fun isValidBST(root: TreeNode) {


    }





