package Tree
// in order left, r, right
// preOrder: r, left and right
// postOrder: left, right, center
fun main() {
    var s = Solution()
    var root = TreeNode(3)
    root.left = TreeNode(4)
    root.right = TreeNode(5)
    s.inorderTraversal(root)
}
internal class Solution {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val res: MutableList<Int> = ArrayList()
        helper(root, res)
        res.forEach {
            println(it)
        }
        return res

    }

    fun helper(root: TreeNode?, res: MutableList<Int>) {
        if (root != null) {
            helper(root.left, res)
            res.add(root.value)
            helper(root.right, res)
        }
    }
}