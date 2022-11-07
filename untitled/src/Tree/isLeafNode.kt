package Tree

fun isLeafNode(node:TreeNode):Boolean{

    return node.left == null && node.right==null
}