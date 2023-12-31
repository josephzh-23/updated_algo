"""
https://leetcode.com/problems/partition-labels/description/
Here use a map that store the following

char    last index
a          8
b          5
"""
from typing import List


def partitionLabels(s: str)-> List[int]:
    lastIndex = {} # char -> last index here

    # like for each indexed
    for i, c in enumerate(s):
        lastIndex[c] = i

    res= []
    size, end = 0, 0

    # go thru it the 2nd time here
    for i, c in enumerate(s):
        size+=1
        end = max(end, lastIndex[c])

        # this is the last index of that character and it's the end we don't see anymore
        # here 
        if(i == end):
            res.append(size)
            size = 0
    return res









