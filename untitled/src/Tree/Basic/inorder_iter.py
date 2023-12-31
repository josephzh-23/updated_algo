def inorder_traversal(root):
    res = []
    if not root:
        return res
    stack = []
    curr_node = root
    while curr_node or stack:
        while curr_node:
            stack.append(curr_node)
            curr_node = curr_node.left
        curr_node = stack.pop();
        res.append(curr_node.val);
        curr_node = curr_node.right;

    return res