package top_tricks


fun main() {
    var str = swap("joseph", 0, 2)
    println(str)
}
// Using this can be very helpful
fun swap(str:String, i: Int, j: Int): String{
    var cArray = str.toCharArray()

    // Swap the first one
    var temp = cArray[i]
    cArray[i] = cArray[j]
    cArray[j] = temp
    return StringBuilder().append(cArray).toString()

}

