class Solution {
    fun is_Interleave(s1: String, i: Int, s2: String, j: Int, res: String, s3: String): Boolean {
        if (res == s3 && i == s1.length && j == s2.length) return true
        var ans = false
        if (i < s1.length) ans = ans or is_Interleave(s1, i + 1, s2, j, res + s1[i], s3)
        if (j < s2.length) ans = ans or is_Interleave(s1, i, s2, j + 1, res + s2[j], s3)
        return ans
    }

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        return if (s1.length + s2.length != s3.length) {
            false
        } else is_Interleave(s1, 0, s2, 0, "", s3)
    }
}