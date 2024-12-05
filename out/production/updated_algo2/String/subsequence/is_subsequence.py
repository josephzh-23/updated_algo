

"""
Is s a subsequence of t as said here, use 2 pointers here  i for s, j for t
traverse t, t and whenever a character matches the

if cur char of t matches cur char of s increment i,

At the end of traversal, if i is equal to the length of s, then s is a subsequence of t.
"""

def isSubsequence(s, t):
    i, j = 0, 0
    while i < len(s) and j < len(t):
        if s[i] == t[j]:
            i+=1
        j+=1

        # if it is then it's a subsequence
    return i == len(s)