package Array_manipulation

import java.util.*
import kotlin.math.max

fun main() {

    longestSubstring("aaabb", 3)
}
fun longestSubstring(s: String, k: Int): Int {
    val maxUnqiueCharCount = getUniqueCharCount(s)
    println("max unique char"+ maxUnqiueCharCount)
    val freqMap = IntArray(26)
    var result = 0

    for (currentUniqueChar in 1..maxUnqiueCharCount) {
        Arrays.fill(freqMap, 0)
        var uniqueCount = 0
        var countAtLeastK = 0
        var windowStart = 0
        var windowEnd = 0

        while (windowEnd < s.length) {
            if (uniqueCount <= currentUniqueChar) {
                val idx = s[windowEnd].toInt() - 'a'.toInt()


                if (freqMap[idx] == 0) {
                    uniqueCount++
                }
                freqMap[idx]++

                if (freqMap[idx] == k) {
                    countAtLeastK++
                }
                windowEnd++
            } else {
                // We need to  shrink
                val idx = s[windowStart].toInt() - 'a'.toInt()
                if (freqMap[idx] == k) {
                    countAtLeastK--
                }
                freqMap[idx]--
                if (freqMap[idx] == 0) {
                    uniqueCount--
                }
                windowStart++
            }

            if (uniqueCount == currentUniqueChar && uniqueCount == countAtLeastK) {
                result = max((windowEnd - windowStart).toDouble(), result.toDouble()).toInt()
            }
        }
    }

    return result
}

private fun getUniqueCharCount(s: String): Int {
    val chars = BooleanArray(26)
    var uniqueCount = 0

    for (ch in s.toCharArray()) {
        val idx = ch.toInt() - 'a'.toInt()
        if (!chars[idx]) {
            uniqueCount++
            chars[idx] = true
        }
    }

    return uniqueCount
}