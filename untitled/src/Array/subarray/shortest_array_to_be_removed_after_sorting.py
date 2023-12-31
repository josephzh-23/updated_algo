"""
Remove subarray from arr such that remaining elemenst are decreasing

 [1,2,3,10,4,2,3,5]

 1. Use a left pointer find first elem not monotonic
 2. Use a right pointer find first elem not monotic

 3. Use a third pointer to check between the 2 to find first non-monotonic spot

"""
from typing import List


def findSolution(s, arr: List[int]):
    n = len(arr)
    l, r = 0, n - 1
    while l < n - 1 and arr[l] <= arr[l + 1]:
        l += 1
    if l == n - 1:
        return 0

    while r > 0 and arr[r] >= arr[r - 1]:
        r -= 1
    # after these 2 operations the left and right will be at monotic point

    # is the answer everything inbetween the 2 different subarrays?
    ans = min(n - l - 1, r)

    """
    Two conditiosn      keep track of max length 
  1.  So now iter thru 1st subarray and check if the elem in 1st subarr<= elem in 2nd subarray
 2. elem in 1st subarr > elem in 2nd subarray, move to 2nd elem of 2nd subarr
    """
    i, j= 0, r
    while i <= l and j < n:
        if arr[j] >= arr[i]:
            ans = min(ans, j - i - 1)
            i+=1
        else:
            j+=1

    return ans













