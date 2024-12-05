"""
The goal is to figure out what the maximum length of a ribbon
 could be so that we get k ribbons of that max length.
One way to think of it would be th

 ribbons = [9, 7, 5], k = 3
 output = 5 here
Explanation:
So what we do is go through the list (using Binary Search since we need to optimize linear search),
 find the mid of the given array and then iterate through the
  list testing the length with each element and

  summing the number of ribbons that can be made with the mid value.
   Then change mid accordingly
"""
from typing import List


def maxlength(ribbons: List[int], k: int):
    # The minumum length of the ribbon that we can cut is 1
    start = 1
    # The maximum length of the ribbon can be the maximum element in the list
    end = max(ribbons)












