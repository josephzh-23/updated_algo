package final_cool

// This will move all the zeros on the left towards the end here
fun main() {
    var arr = intArrayOf()
}
private fun moveZerosToLeft(arr: IntArray): IntArray {
    var f = 0
    var l = arr.size - 1
    val newArr = IntArray(arr.size)
    for (i in arr.indices) {
        if (arr[i] == 0) {
            newArr[l--] = arr[i]
        } else {
            newArr[f++] = arr[i]
        }
    }
    return newArr
}
