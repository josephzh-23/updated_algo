

# recursion with stuff there

"""
If the root is null, return 0 because there are no nodes in an empty tree.
If both the left and right child of the root are null,
 return 1 because the root itself is a leaf node.

If the left child of the root is null,
 recursively calculate the minimum depth of the right subtree and add 1 to it (to account for the root node).

If the right child of the root is null,
 recursively calculate the minimum depth of the left subtree and add 1 to it.
If both the left and right child of the root are not null, recursively calculate the minimum depth of both subtrees, and return the minimum of the two depths plus 1 (to account for the root node).

"""

def minDepth(s, root):
    def dfs(r):

        if not r:
            return 0
        if not r.left and r.right:
            return 1 + dfs(r.right)

        elif not r.right and r.left:
            return 1 + dfs(r.left)

        else:
            return 1 + min(dfs(r.left), dfs(r.right))
    return dfs














