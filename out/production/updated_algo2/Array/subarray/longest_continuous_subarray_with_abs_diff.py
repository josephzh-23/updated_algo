"""

Longest Continuous Subarray With Absolute Diff Less
 Than or Equal to Limit
 https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
"""
import heapq
from queue import PriorityQueue
from typing import List

from Python_basics.max_heap import MaxHeap

h = heapq
# the 2 heap solution
# the answer has to be smaller than here
def longestSubArray(nums: List[int], limit: int):
    # most intrinsic stuff
    maxlength = 1
    length, left = 0, 0

    # left for finding the length of the window here

    minheap = PriorityQueue()  # find the minimum
    maxheap = MaxHeap()  # fidn max

    for right in range(len(nums)):  # right end of the window here

        # first of all, we push the [right] element to both the min_heap and the max_heap
        # because we need to first "slide" the window

        # make sure min and max are valid while slidning window here
        minheap.put((nums[right], right))
        maxheap.add((nums[right], right))


        """
        1. In this step, retrieve the min element and the max elem in 1 step here 
        make sure max and min are withiin window range  (left <= index <= right)
        
        2. Also need to pop the maxheap until we find the largest element in the window here 
        """
        while minheap[0][1] < left:
            minheap.get()
        while maxheap.top()[1] < left:
            maxheap.pop()

        # find the min and max in the window and check if the window is valid or not
        if maxheap.top()[0] - minheap.get()[0] <= limit:
            # if valid we can update teh answer
            maxlength = max(maxlength, right - left + 1)
        else:
            #we just move the left end of the window
            return maxlength

nums = [8,2,4,7]; limit = 4
print(longestSubArray(nums, limit))