"""
Compare first character in s and t.
If equal, make recursive call slicing first character from s and t.
If not equal, make recursive call slicing first character only from t.

Base Cases:

If s is empty string, it means we've gone through entire subsequence and return true.
if t is empty string, it means we've gone through entire original string without matching subsequence and return false.
"""

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if len(s) == 0:
            return True
        if len(t) == 0:
            return False

        if s[0] == t[0]:
            return self.isSubsequence(s[1:], t[1:])

        return self.isSubsequence(s, t[1:])