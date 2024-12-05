# check if path exists here above in the code
from Tree.Basic.level_order_traversal import TreeNode

arr = [5, 8, 6, 7, 14]
s = set(arr)
def checkIfPathExists(root: TreeNode):

    # use a set to represent here


    if root:
        if(root.val in s):
            s.remove(root.val)
        # First recur on left child
        checkIfPathExists(root.left)

        # now recur on right child
        checkIfPathExists(root.right)
    print(s)
    if s:
        return False
    else:
        return True
root = TreeNode(5)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(2)
root.left.right = TreeNode(4)
root.left.left.left = TreeNode(1)
root.right.left = TreeNode(6)
root.right.left.right = TreeNode(7)
print(checkIfPathExists(root))