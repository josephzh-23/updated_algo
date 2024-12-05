"""
1 at the start the other at the end here
"""

def reverse(s):
    i, j = 0, len(s) - 1
    s = list(s)
    while(i < j):
        s[i], s[j] = s[j], s[i]
        i+=1
        j-=1

    return s

str = "abcde"
print(reverse(str))