
from typing import List

"""

Output: 3

If you can travel around the circut
cost[i] of going to travel from the ith station to the next ith station

return the starting gas station's index if you can travel around the circuit in the
clockwise direction
"""
from Two_array.find_difference_of_two_array import size


def canCompleteCircut(gas: List[int], cost: List[int])-> int:

    if sum(gas) < sum(cost):
        return -1

    total = 0
    res = 0

    # try the first index and see if it works here or not

    for i in size(gas):
        total += (gas[i] - cost[i])

        #this position does not work, then try the next position, reset the total here
        if total < 0:
            total = 0
            res = i + 1

    return res

















