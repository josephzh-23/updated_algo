//package Tree
//
//import Tree.Basic.TreeNode
//import java.lang.Integer.max
//
///*
//Max depth of binary tree here
//Usually it's 1 + max(dfs(left) + dfs(right)) that's the above here
//
// */
//
//fun maxDepth5(r: TreeNode?):Int{
//
//    if(r== null){
//        return 0
//    }
//
//    return 1 + max(maxDepth5(r.left) ,maxDepth5(r.right))
//}
