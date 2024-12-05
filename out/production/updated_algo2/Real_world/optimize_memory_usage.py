"""


Foreround = [1, 7, 2, 4, 5, 6]
background = [3, 1, 2]          maximize the memory usage here
"""
import sys
from math import floor
from queue import PriorityQueue

#  https://leetcode.com/discuss/interview-question/823550/amazon-oa-2020-optimize-memory-usage
"""
The idea is to iterate thru first arr and find upperbound in 2nd arr,
and update max in the iteration
"""

def memoryUsage(foregroundTasks, backgroundTasks, k):
    closest = 0
    ans = []

    backgroundTasksMap = {}

    # create a map to store the value => id before the sorting takes place down there
    for(i, n) in enumerate(backgroundTasks):
        backgroundTasksMap[n] = i

    print(backgroundTasksMap)
    # sor the background tasks that need to sorted here
    backgroundTasks.sort()
    #
    # # iterate forground tasks and do binary search on the bavckground tassk
    # # find the closest element to k for each element in froregroundtasks
    #
    for id, value in enumerate(foregroundTasks):

        # the target that we should be looking for in the 2nd array here
        target = k - value

        # index - 1 is the index of number which is closest to k
        index = modifiedBiSearch(backgroundTasks, target) -1
        print("index is ", index)
        # if the index is in range, compare with max and update max if this round's
        # sum is > max here

        if 0 <= index <= len(backgroundTasks):
            #the original index here
            backgroundTaskId = backgroundTasksMap.get(backgroundTasks[index])

            sum = value + backgroundTasks[index]

            if(sum > closest):
                ans = []
                closest = sum
                ans.append((id, backgroundTaskId))
            elif sum == closest:
                ans.append((id, backgroundTaskId))

        elif value> closest:
            ans = [(id, -1)]
            # the index not in range , can only use the first element and will be (id, -1)
            closest = value
        elif value == closest:
            ans.append((id, -1))

    return ans

# returns first index of i in backgrounds such that
# a[i] > target the upperbound
def modifiedBiSearch(backgroundTasks, target):
    low = 0
    high = len(backgroundTasks) - 1
    mid = 0

    while low <= high:

        # rounds down here
        mid = low + floor(high- low /2)

        # If x is greater, ignore left half
        if backgroundTasks[mid] > target:
            high = mid - 1
        # If x is smaller, ignore right half
        else:
            low = mid + 1

    # this is the special search here
    return low


 

foregroundTasks = [1, 7, 2, 4, 5, 6]
backgroundTasks = [3, 1, 2]
print(memoryUsage(foregroundTasks, backgroundTasks, 6))











