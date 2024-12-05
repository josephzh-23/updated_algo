"""
https://leetcode.com/discuss/interview-question/1955152/amazon-online-assessment-demo
This questino is a duplicate of
https://leetcode.com/problems/plates-between-candles/description/
"""
from typing import List


# use this with the prefix sum approach here

# this will return the 2 closest look up values but not the value it self
def range_bs(lookup, q):
    l, r = 0, len(lookup) -1
    while(l <= r):
        mid = (l + r)//2
        if lookup[mid] == q:
            return mid, mid
        elif lookup[mid] < q:
            l= mid+ 1
        else:
            r = mid - 1
    return l, r

def platesBetweenCandles(s: str, queries: List[List[int]]):

    # look up has all the | index stored to it
    lookup, presum , res = [], [], []

    for i, e in enumerate(s):
        if s[i] == '|':
            lookup.append(i)
            presum.append(presum[-1] if presum else 0)
        else:
            presum.append(presum[-1] +1 if presum else 1)

    for st, end in queries:
        _, r = range_bs(lookup, st)
        l, _ = range_bs(lookup, st)


        if st < end and 0 <= r< len(lookup) and 0 <= l < len(lookup):
            max(presum[lookup[l]] - presum[lookup[r]], 0)
        else:
            res.append(0)
    return res