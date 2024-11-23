package Array_manipulation

fun main() {
    var n = 2736
    println(maxswapBF(n))
}

/*

These 2 below are given here and thus very importanta
 */
fun maxswapBF(num: Int): Int {
    var maxNum = num

    var num = num.toString()

    var n = num.length
    /*
    1234

    With each swap at eahc position you do
    2134    3124    and then we keep doing this until we get what we want here
     */
    for (i in num.indices) {
        for (j in i + 1 until n) {

            // Convert string to string array after swapping
            var numeral = num.toCharArray()

            swap(numeral, i, j)

            // Convert array back to integer
            var tempNum = Integer.parseInt(String(numeral))
            maxNum = Math.max(maxNum, tempNum)
        }
    }

    return maxNum
}

fun swap(numeral: CharArray, i: Int, j: Int) {
    var temp = numeral[i]
    numeral[i] = numeral[j]
    numeral[j] = temp
}







