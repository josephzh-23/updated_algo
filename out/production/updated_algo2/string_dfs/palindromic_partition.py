"""
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
"""
def isPalindrome(s, start, end):
    while( start < end):
        if(s[start] != s[end]): return False
        start+=1
        end-=1
    return True

def dfs(idx, s, path, res):
    if (idx == len(s)):
        res.append(path.copy())
        return

    for i in range(idx, len(s)):
        if(isPalindrome(s, idx, i)):
            print("string is", s[idx: i - idx + 1])
            path.append(s[idx: i - idx + 1])
            dfs(i +1, s, path, res)
            path.pop()


def palindromePartition(s):
    # remember the res here will be a list of lists here
    res = []
    path = []

    dfs(0, s, path, res)
    return res

print(palindromePartition("aab"))

str = "aab"
print(str[1:2])