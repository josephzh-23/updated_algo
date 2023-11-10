package Array.subarray

import January_3rd.print
import Util.printList
import java.util.*


/*

Given an array of integers arr[], the task is to count the number of sub-arrays such that the
 average of elements present in the sub-array is greater than the average of elements that are not present in the sub-array.
 */

fun main() {
    var trial = intArrayOf(3, 4, 2)
    answer(trial).print()

    // The above averages are [3, 4], [3,4, 2], [4]
}

fun answer(arr: IntArray): Array<IntArray?>? {
    val resultList = ArrayList<IntArray>()
    var n = arr.size
    var totalSum = 0
    for (k in arr) {
        totalSum += k
    }
    for (i in 0 until n) {
        var sumCurrent = 0
        for (j in i until arr.size) {
            sumCurrent += arr[j]
            if (averageBetween(
                    sumCurrent, i, j
                ) > averageForRest(
                    totalSum, sumCurrent, n, i, j
                )
            ) {
                resultList.add(intArrayOf(i + 1, j + 1))
            }
        }
    }
    resultList.forEach {
        printList(it.toList())
    }
    return resultList.toArray(arrayOfNulls(0))
}

fun averageBetween(sumCurrent: Int, i: Int, j: Int): Int {
    return sumCurrent / (j - i + 1)
}

fun averageForRest(totalSum: Int, sumCurrent: Int, n: Int, i: Int, j: Int): Int {
    val elemCount = n - (j - i + 1)
    return if (elemCount == 0) elemCount else (totalSum - sumCurrent) / elemCount
}








