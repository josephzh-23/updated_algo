package two_pointer

// and then using this we could have x = y and then
fun isSubsequence(s: String, t: String): Boolean {
    val leftBound = s.length
    val rightBound = t.length
    var pLeft = 0
    var pRight = 0
    while (pLeft < leftBound && pRight < rightBound) {
        // move both pointers or just the right pointer
        if (s[pLeft] == t[pRight]) {
            pLeft += 1
        }
        pRight += 1
    }
    return pLeft === leftBound
}
