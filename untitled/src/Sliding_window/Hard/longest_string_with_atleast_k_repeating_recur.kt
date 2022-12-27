package Sliding_window.Hard
// The answer for this would be O(n^2) solution
// S: O(n)  the answer for this would be O(n^2)
fun longestSubstring(s: String, k: Int): Int {
    val freq = IntArray(26)
    val str = s.toCharArray()
    for (c in str) {
        val index = c.code - 'a'.code
        freq[index]++
    }
    // Use this valid to indicate if false or true
    // freq[char] < k       then not valid
    var valid = true
    var start = 0
    var maxLen = 0
    for (end in 0 until s.length) {
        // TC -> O(N2)

        // This is the point of split if below = true
        if (freq[str[end].code - 'a'.code] > 0 && freq[str[end].code - 'a'.code] < k) {
            val subString = s.substring(start, end)
          // Check for the 1st part of string after split
            maxLen = Math.max(maxLen, longestSubstring(subString, k))

            // Check for 2nd part of str after split
            // a a b b c d e f
            // so it would take def if spliting at c
            start = end + 1
            valid = false
        }
    }
    return if (valid) {
        s.length
        // Not valid anymore
    } else {
        Math.max(maxLen, longestSubstring(s.substring(start), k))
    }
}

