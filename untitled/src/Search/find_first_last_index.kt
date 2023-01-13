package Search

class FirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = findLeftBound(nums, target)
        val right = findRightBound(nums, target)
        return intArrayOf(left, right)
    }

    private fun findLeftBound(nums: IntArray, target: Int): Int {
        var index = -1
        var low = 0
        var high = nums.size - 1

        // Standard binary search
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (nums[mid] == target) {
                index = mid
                high = mid - 1 // Look in the left sub-array
            } else if (nums[mid] < target) low = mid + 1 else high = mid - 1
        }
        return index
    }

    private fun findRightBound(nums: IntArray, target: Int): Int {
        var index = -1
        var low = 0
        var high = nums.size - 1

        // Standard binary search
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (nums[mid] == target) {
                index = mid
                low = mid + 1 // Look in the right sub-array
            } else if (nums[mid] < target) low = mid + 1 else high = mid - 1
        }
        return index
    }
}