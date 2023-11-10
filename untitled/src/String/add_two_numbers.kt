package String

import LinkedList.ListNode

// Add Two String.Numbers (Java improved)
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2


    val dummyHead = ListNode(0)
    var curr: ListNode? = dummyHead
    var carry = 0
    while (l1 != null || l2 != null || carry != 0) {
        val x = if (l1 != null) l1.value else 0
        val y = if (l2 != null) l2.value else 0
        val sum = carry + x + y
        carry = sum / 10

        // The next one would be 13%10= 3, 3 being the remainder here
        curr!!.next = ListNode(sum % 10)
        curr = curr.next
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
    }
    return dummyHead.next
}