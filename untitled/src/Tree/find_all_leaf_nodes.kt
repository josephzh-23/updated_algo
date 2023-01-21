package Tree

import TreeNode

fun printAllLeafNodes(node:TreeNode, list: MutableList<TreeNode>){

    if(node==null){
        return
    }
    // reach a leaf node here
    if(node.left==null && node.right==null){
        list.add(node)
    }
    printAllLeafNodes()

}