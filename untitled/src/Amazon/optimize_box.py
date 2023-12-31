
"""
PROBLEM 1 : If we sort the array, the subset A with maximal total weight is the shortest trailing subarray with
sum greater than half of the total sum, e.g. for the example above,

sorted(arr) = [1, 2, 2, 3, 4, 5]
sum(arr) / 2 = 17 / 2 = 8.5
A = [4, 5]
sum(A) = 9

"""
from queue import PriorityQueue

from Two_array.find_difference_of_two_array import size





def minimalHeavyStuff(arr):
# example here would be : [1, 2, 2, 3, 4, 5] here
    ans = []
    q = PriorityQueue()
    curweight = 0
    totalWeight = 0
    for i in arr:
        q.put(i)

    for i in size(arr):
        high = q.get()
        curweight += high
        # how to get to the other half
        ans.append(high)
        if(curweight > totalWeight - curweight):
            break


    print(high)
arr = [1, 2, 2, 3, 4, 5]
minimalHeavyStuff(arr)






