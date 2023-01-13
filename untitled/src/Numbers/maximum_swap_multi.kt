package Numbers

import tricks.print

// Find the max digit
// This allows more than 1 swap

// O (m *n)

fun main() {
    var rr = 1234
    maximumSwap(rr).print()
}
fun maximumSwap(num: Int): Int {

    // Have to swap each digit
    var newVal = num.toString()

    // Use a temp to hold the var
//    var temp = newVal
    for (i in 0 until newVal.length) {
        for (j in i + 1 until newVal.length) {
            var newStr = swap(newVal, i, j)

            // 2739 > 7239
            if (newStr.toInt() > newVal.toInt()) {
                    newVal = newStr
            }
        }
    }
    return newVal.toInt()
}

fun swap(str: String, i: Int, j: Int): String {
    val ch = str.toCharArray()
    val temp = ch[i]
    ch[i] = ch[j]
    ch[j] = temp
    return String(ch)
}

