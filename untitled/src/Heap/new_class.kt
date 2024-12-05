package Heap

import java.util.*

internal class Data(var count: Int, var value: Int) : Comparable<Data?> {
    override fun compareTo(other: Data?): Int {
        // For a min heap, use this comparison:
        return Integer.compare(this.count, other?.count!!)

        // For a max heap, use this comparison:
        // return Integer.compare(other.key, this.key);
    }
}

fun findLeastUniqueIntegers(nums: IntArray, k: Int): Int {
    var k = k;
    var map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    var hp = PriorityQueue<Data>()
    println("map is" + map)
    var res: MutableList<List<Int>> = ArrayList()
    for (m in map.entries) {
        hp.add(Data(m.value, m.key))

    }

    println(hp)
    while (k > 0) {
        if (hp.isNotEmpty()) {
            var elem = hp.poll()
            elem.count--
            if (elem.count > 0) {
                hp.add(Data(elem.count, elem.value))
            }
            k -= 1
        }
    }
    println("the list is" + hp.toList())
    return 0
}

fun main() {
    findLeastUniqueIntegers(intArrayOf(4, 3, 1, 1, 3, 3, 2), 2)
}
