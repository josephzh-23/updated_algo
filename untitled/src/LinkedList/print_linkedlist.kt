package LinkedList

import Tree.TreeNode

fun printLinkedList(r: ListNode?){
    var temp = r
    while(temp?.next!=null){
        println(temp.value)
        temp= temp.next
    }
}