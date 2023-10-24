package Tree.Hard

import TreeNode


fun main() {


}
fun sumRootLeftNumbers(r: TreeNode?, value: Int):Int{

    // We will try to add 10 each time we get to the end here

    //
    if (r == null) {
        return 0
    }

    // Update the value here
    var value = value * 10 + r.value

    // If current node is leaf, then return the current value of val
    if(r.left == null && r.right == null){
        return value
    }

    // return the sun of values for left and right subtree
    //
    return sumRootLeftNumbers(r.left, value) + sumRootLeftNumbers(r.right, value)

}
