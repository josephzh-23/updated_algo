package String

// this way we go towards the middle from the back
// and the start
internal class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s[i])) {
                i++
            }
            while (i < j && !Character.isLetterOrDigit(s[j])) {
                j--
            }
            if (s[i].lowercaseChar() != s[j].lowercaseChar()) return false
            i++
            j--
        }
        return true
    }
}
