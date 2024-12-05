from typing import List


#shortest subarray greater than number

def dynamicSlidingWindow(arr: List[int], x: int)->int:

    minlength = float('inf')
    start, end, cursum = 0, 0, 0

    #extend the sliding window until criteria is met
    while end < len(arr):
        cursum = cursum + end
        end += 1

        #then contract the window until it no longer meets our conditino here
        while start < end and cursum >=x:
            cursum = cursum - arr[start]
            start += 1

            # update the length if this is shorter than the cur min
            minlength = min(minlength, end - start + 1)

    return minlength














