package Tree

import java.util.*


// Data structure to store a binary tree node
internal class Node(var data: Int) {
    var left: Node
    var right: Node? = null

    // Function to create a new binary tree node having a given key
    init {
        left = right!!
    }
}

internal object Main {
    // Iterative function to perform inorder traversal on the tree
    fun inorderIterative(root: Node?) {
        // create an empty stack
        val stack = Stack<Node>()

        // start from the root node (set current node to the root node)
        var curr = root

        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null) {

            // Left first and then right
            if (curr != null) {
                stack.push(curr)
                curr = curr.left
            } else {
                // This is the parent stuff
                curr = stack.pop()
                print(curr.data.toString() + " ")

                // Then we traverse to the right
                curr = curr.right
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.right!!.left = Node(5)
        root.right!!.right = Node(6)
        root.right!!.left.left = Node(7)
        root.right!!.left.right = Node(8)
        inorderIterative(root)
    }
}