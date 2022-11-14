package Tree;

// Data structure to store a binary tree node
class PreOrderNode
{
    int data;
    PreOrderNode left, right;

    // Function to create a new binary tree node having a given key
    public PreOrderNode(int key)
    {
        data = key;
        left = right = null;
    }
}

class Main2
{
    // Recursive function to perform preorder traversal on the tree
    public static void preorder(PreOrderNode root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
               2       3
              /      /   \
            4      5       6
                  / \
                7     8
        */

        PreOrderNode root = new PreOrderNode(1);
        root.left = new PreOrderNode(2);
        root.right = new PreOrderNode(3);
        root.left.left = new PreOrderNode(4);
        root.right.left = new PreOrderNode(5);
        root.right.right = new PreOrderNode(6);
        root.right.left.left = new PreOrderNode(7);
        root.right.left.right = new PreOrderNode(8);

        preorder(root);
    }
}
