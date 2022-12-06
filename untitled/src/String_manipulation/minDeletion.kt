package String_manipulation

// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/


fun minDeletions(s: String): Int {
    var deletion = 0

    // Used to store frequency of each character
    // a-> 3    b-> 2    c-> 2
    val freq = IntArray(26)
    for (c in s.toCharArray()) {
        freq[c - 'a']++
    }
    // 3   2   1
    val uniqueFreq: MutableSet<Int> = HashSet()

    // this will iter over all the char in frequency here
    for (count in freq) {

        var tempCount = 0
        // if it contains 3, and we see another 3
        while (count > 0 && uniqueFreq.contains(count)) {
            deletion++
            tempCount = count -1
        }
        uniqueFreq.add(tempCount)
    }
    println(deletion)
    return deletion
}

fun main() {
    minDeletions("aaabbbcc")
}
