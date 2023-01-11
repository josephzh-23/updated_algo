package Search

object Ceiling {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(2, 3, 5, 9, 14, 16, 18)
        val target = 15
        val ans = ceiling(arr, target)
        println(ans)
    }

    // return the index of smallest no >= target
    fun ceiling(arr: IntArray, target: Int): Int {

        // but what if the target is greater than the greatest number in the array
        if (target > arr[arr.size - 1]) {
            return -1
        }
        var start = 0
        var end = arr.size - 1


        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            val mid = start + (end - start) / 2

            // on the left
            if (target < arr[mid]) {
                end = mid - 1

            } else if (target > arr[mid]) {
                start = mid + 1
            } else {
                // ans found
                return mid
            }
        }
        return start
    }
}