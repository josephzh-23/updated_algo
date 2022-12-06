package Util

fun frequencyOfCharacters(s: String) {
    var deletion = 0

    // Used to store frequency of each character
    // a-> 3    b-> 2    c-> 2
    val freq = IntArray(26)
    for (c in s.toCharArray()) {
        freq[c.code - 'a'.code]++
    }
}