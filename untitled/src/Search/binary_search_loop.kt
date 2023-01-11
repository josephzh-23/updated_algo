package Search

fun binarySearch(
        arr: IntArray, target: Int, start: Int, end: Int): Int {
    var start = start
    var end = end
    var index = Int.MAX_VALUE
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (arr[mid] < target) {
            start = mid + 1
        } else if (arr[mid] > target) {
            end = mid - 1
        } else if (arr[mid] == target) {
            index = mid
            break
        }
    }
    return index
}