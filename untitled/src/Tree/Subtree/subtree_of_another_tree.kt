package Tree.Subtree

import Tree.Basic.TreeNode

/*

If we work on this one here what woudl we get here?

I am acutally not too sure right off the bat
 */
internal class Solution {


    /**
     * Determines if a binary tree has a subtree that matches a given subtree.
     *
     * @param root The root node of the main tree.
     * @param subRoot The root node of the subtree that we are looking for in the main tree.
     * @return boolean indicating if the subtree is present in the main tree.
     */
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        // If the main tree is null, subRoot cannot be a subtree
        if (root == null) {
            return false
        }
        // THis keeps going down the tree level and check for the left or the right here
        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot)
    }
    // This is the code that we wanted before here
    /**
     * Helper method to determine if two binary trees are identical.
     *
     * @param root1 The root node of the first tree.
     * @param root2 The root node of the second tree.
     * @return boolean indicating whether the trees are identical or not.
     */
    private fun isIdentical(root1: TreeNode?, root2: TreeNode?): Boolean {
        // If both trees are empty, then they are identical
        if (root1 == null && root2 == null) {
            return true
        }
        // If both are not null, compare their values and check their left & right subtrees
        if (root1 != null && root2 != null) {
            return root1.value === root2.value && isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right)
        }
        // If one is null and the other isn't, they are not identical
        return false
    }
}

