import LinkedList.ListNode
import Tree.insert

fun flattenTree(root: TreeNode?): ListNode{
// dummy node
    var list = ListNode(0)

    root?.apply {

        flatten(left)
        //process this here
        list.next = ListNode(value)
        flatten(right)


    }
    return list


}

fun main() {
    var n= TreeNode(3)
    n = insert(n, 2)
    n = insert(n, 5)

    flatten(n)
}



