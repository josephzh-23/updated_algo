package Backtracking
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
/*      "abc"   "edf"
"23"    ad  ae  af  bd  be   bf   cd  ce   cf
"23"
 */

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return ArrayList()
    val result: MutableList<String> = ArrayList()
    // INitially combine means 0 here
    combine(0, StringBuilder(), result, digits)
    return result
}

private fun combine(i: Int, str: StringBuilder, result: MutableList<String>,
                    digits: String) {
    // The digits legnth here is the len of the number in input
    /*
    "333"   len 3
     */
    if (i >= digits.length) {
        result.add(str.toString())
        return
    }
    /*
    Combining the data from d[i]
     */
    val d = digits[i]
    for (c in mappings[Character.getNumericValue(d)]) {
        // First iter   abc
        str.append(c)
        combine(i + 1, str, result, digits)
        // it will delete the b here
        str.deleteCharAt(str.length - 1)
    }
}

private val mappings = arrayOf(charArrayOf(), charArrayOf(),
        charArrayOf('a', 'b', 'c'),
        charArrayOf('d', 'e', 'f'),
        charArrayOf('g', 'h', 'i'), charArrayOf('j', 'k', 'l'), charArrayOf('m', 'n', 'o'), charArrayOf('p', 'q', 'r', 's'), charArrayOf('t', 'u', 'v'), charArrayOf('w', 'x', 'y', 'z'))

fun main() {
    letterCombinations("23")
}