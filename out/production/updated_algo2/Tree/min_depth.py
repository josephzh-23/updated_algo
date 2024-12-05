from Tree.Basic.level_order_traversal import TreeNode

count = 0
def printInorder(root):

    global count
    if root:
        if not root.left and not root.right:
            count+=1
            count = min(count, count)
        # First recur on left child
        printInorder(root.left)

        # now recur on right child
        printInorder(root.right)

    return count
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.left.right = TreeNode(7)
print(printInorder(root))





