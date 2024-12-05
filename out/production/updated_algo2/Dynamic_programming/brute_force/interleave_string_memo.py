#
#
# """
# The memo side prob a bit harder



# memo[i][j] stores 1/0 depending on whether cur portion of string up to ith index for s1 and
# up to jth idx of s2 has been evaluated or not



class Solution:
    """
    aadbbbaccc
    """
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        self.s1 = s1
        self.s2 = s2
        self.s3 = s3
        self.memo = {}
        return self.recurse(0, 0, 0)

    def recurse(self, i, j, k):
        if k == len(self.s3) and i == len(self.s1) and j == len(self.s2):
            return True
        if (i, j) in self.memo:
            return self.memo[(i, j)]
        res = False
        if (i < len(self.s1) and k < len(self.s3) and self.s1[i] == self.s3[k]):
            res = res or self.recurse(i + 1, j, k+1)
        if (j < len(self.s2) and k < len(self.s3) and self.s2[j] == self.s3[k]):
            res = res or self.recurse(i, j+1, k+1)

        self.memo[(i, j)] = res
        return res
