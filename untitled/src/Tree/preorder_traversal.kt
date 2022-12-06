package Tree

// Data structure to store a binary tree node
internal class PreOrderNode(var data: Int) {
    var left: PreOrderNode?
    var right: PreOrderNode? = null

    // Function to create a new binary tree node having a given key
    init {
        left = right
    }
}

internal object Main2 {
    // Recursive function to perform preorder traversal on the tree
    fun preorder(root: PreOrderNode?) {
        // return if the current node is empty
        if (root == null) {
            return
        }
        print(root.data.toString() + " ")
        preorder(root.left)
        preorder(root.right)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        /* Construct the following tree
                   1
                 /   \
               2       3
              /      /   \
            4      5       6
                  / \
                7     8
        */
        val root = PreOrderNode(1)
        root.left = PreOrderNode(2)
        root.right = PreOrderNode(3)
        root.left!!.left = PreOrderNode(4)
        root.right!!.left = PreOrderNode(5)
        root.right!!.right = PreOrderNode(6)
        root.right!!.left!!.left = PreOrderNode(7)
        root.right!!.left!!.right = PreOrderNode(8)
        preorder(root)
    }
}