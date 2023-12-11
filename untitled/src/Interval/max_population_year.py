# can use the sweep line algo for this

"""
https://leetcode.com/problems/maximum-population-year/description/
Input: logs = [[1993,1999],[2000,2010]]
Output: 1993

Can get the maximum people alive during this time here

TC: O (n log n)
due to free initiliazation here
"""
from typing import List


def maxPopulation(years: List[List[int]]):

    # so this would be {1993: 1} as the answer here
    lines = {}
    for p in years:
        # so if it's [1993, 1999] we increase 1 at 1993 and minus 1 at 1999
        lines[p[0]] += 1
        lines[p[1]] -= 1
    count = 0
    maxP = 0
    year = 0
    for i in lines:
        count += i[1]

        # this is the year with the max as we said before here
        if(count > maxP):
            maxP = count
            year = i[0]




