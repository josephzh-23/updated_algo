"""

TC: O(2^n)
s1, s2 the 2 substrings
and s3 is the actual substring
"""
def isInterLeave(s1, i, s2, j, res, s3):
    l1, l2 = len(s1), len(s2)
    if(res == s3 and i == l1 and j == l2):
        return True
    ans = False

    # res here would take up whatever up to that point there residual
    # if
    if(i < l1):
        ans = ans or isInterLeave(s1, i + 1, s2, j, res + s1[i], s3)
    if (j < l2):
        ans = ans or isInterLeave(s1, i, s2, j + 1, res + s2[j], s3)
    return ans

#the api that hides the internal impl
def isInterLeavePub(s1, s2, s3):
    if (len(s1) + len(s2) != len(s3)): return False
    return isInterLeave(s1, 0, s2, 0, "", s3)





