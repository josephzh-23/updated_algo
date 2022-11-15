//package Tree
//
//// Low and high represent the ranges here
//fun validate(root: TreeNode?, min: Int?, max: Int?): Boolean {
//    // Empty trees are valid BSTs.
//    if (root == null) {
//        return true
//    }
//    /*
//     Return false when
//     1. r.val < low
//     */
//
//    return if (min != null && root.value <= min || max != null && root.value >= max) {
//        false
//    } else validate(root.right, root.value, max) && validate(root.left, min, root.value)
//    // The left and right subtree must also be valid.
//}
//
//fun isValidBSTRecur(root: TreeNode?): Boolean {
//    return validate(root, null, null)
//}