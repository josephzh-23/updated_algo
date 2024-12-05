//package Tree.Count
//
//import Tree.Basic.TreeNode

/*


The problem is if the root is root = [1, 2, 3]

Then we would have 1-> 2        for the 1st one here
1-> 3       for the 2nd one

And that's it here

12 + 13 = 25 here

And how does this work here?


TC: O(n) each node is visited exactly once
    1
   / \
  2   3
 / \
4   5


At the root node (1), we update s to s * 10 + 1, which is 1.
We move to the left child (2). Now s is 1 * 10 + 2 = 12.

    At node (2) we have two children,

On the left child:
    so we apply DFS to the left child (4).
Now s becomes 12 * 10 + 4 = 124. Since (4) is a leaf node, we return 124.

At every operation we time things by 10

    Also consider the right child here we have
We also need to consider the right child (5).
We apply DFS to (5) with s as 12 * 10 + 5 = 125. Since (5) is also a leaf node, we return 125.

    And then the total here would then become 124 + 125 = 259 here


    And then here the code here wuold be 4 +
 */
//
//
//fun main() {
//
//}
//fun sumRootLeafNumbers(r: TreeNode?, value: Int):Int{
//
//    // We will try to add 10 each time we get to the end here
//
//    //
//    if (r == null) {
//        return 0
//    }
//
//    // Update the value here with a number * 10
//    var value = value * 10 + r.value
//
//    // If current node is leaf, then return the current value of val
//    if(r.left == null && r.right == null){
//        return value
//    }
//
//    // return the sun of values for left and right subtree
//    //
//    return sumRootLeafNumbers(r.left, value) + sumRootLeafNumbers(r.right, value)
//
//}
