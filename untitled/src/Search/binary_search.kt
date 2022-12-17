package Search

// Begin with mid elem,
// Java implementation of recursive Binary Search
// TC: O(logn)
internal class BinarySearch {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    fun binarySearch(arr: IntArray, l: Int, r: Int, target: Int): Int {
        if (r >= l) {
            val mid = l + (r - l) / 2

            if (arr[mid] == target) return mid

            return if (target< arr[mid]) binarySearch(arr, l, mid - 1, target)
            else binarySearch(arr, mid + 1, r, target)

        }
        return -1
    }

    companion object {
        // Driver method to test above
        @JvmStatic
        fun main(args: Array<String>) {
            val ob = BinarySearch()
            val arr = intArrayOf(2, 3, 4, 10, 40)
            val n = arr.size
            val x = 10
            val result = ob.binarySearch(arr, 0, n - 1, x)
            if (result == -1) println("Element not present") else println("Element found at index "
                    + result)
        }
    }
}
/* This code is contributed by Rajat Mishra */