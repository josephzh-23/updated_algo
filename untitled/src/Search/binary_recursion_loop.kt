package Search

fun binarySearch(
        sortedArray: IntArray, target: Int, start: Int, end: Int): Int {
    var low = start
    var high = end
    var index = Int.MAX_VALUE
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (sortedArray[mid] < target) {
            low = mid + 1
        } else if (sortedArray[mid] > target) {
            high = mid - 1
        } else if (sortedArray[mid] == target) {
            index = mid
            break
        }
    }
    return index
}