package Basics

fun main() {
    var nums = intArrayOf(1, 2, 3, 4, 5)
    var map = mutableMapOf<Int,Int>()
    for(num in nums) {
        map[num] = map.getOrDefault(num,0) + 1
    }

}

