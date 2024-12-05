package Heap

import java.util.*


/*

 */

fun findKthLargestElem(num: IntArray, k: Int): Int {

    var maxHeap = PriorityQueue<Int>(reverseOrder())


    maxHeap.addAll(num.toList())
    for (i in 0 until k  ){
        maxHeap.poll()
    }
    println(maxHeap)
    return 0
}
fun main() {
    findKthLargestElem(intArrayOf(3,2,1,5,6,4), 2)
}
