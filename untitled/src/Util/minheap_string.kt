package Util

import java.util.*

fun main() {

    val pq = PriorityQueue<String>()

    pq.add("xeno")
    pq.add("kuroko")
    pq.add("kagami")
    pq.add("Aomie")
    pq.run{
        println(poll())
    }
}