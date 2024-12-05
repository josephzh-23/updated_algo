

# a target index is the

"""
Find target indices after sorting an event, 0th indexed array nums
and a target element here, target index i where nums[i] == target

So you have nums[1, 2, 5, 2 , 3]
target ==2  output [1, 2] here

After sorting nums becomes [1, 2, 2, 3, 5] up there
"""
from Search.Basic.find_first_index import first
from Search.Basic.find_last_index import last

# 1, 2, 5, 2, 3 -> target =2

# then becomes [1, 2] here

"""
https://leetcode.com/problems/find-target-indices-after-sorting-array/solutions/
Explanation: After sorting, nums is [1,2,2,3,5].
So you can have 2 of these here 
The indices where nums[i] == 2 are 1 and 2.
"""







# so the following allows you to find first and last here

# once found here


def ans(arr,target):
    arr.sort()
    # find the first occurence here
    firstIdx = first(arr, target)
    lastIdx = last(arr, target)

    output = []
    if first == -1: return output
    for i in range(firstIdx, lastIdx + 1):
        output.append(i)
ans([1,2, 2, 4, 5], 2)















