
"""

https://leetcode.com/problems/sum-of-subarray-minimums/description/

Find sum of all the minimums in the subarray here leetcode
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.




Input arr = [3,1,2,4]

The idea is to find the total number of subarrays for each element, with that element being the minimum.

How to find :-
First find out the maximum subarray with that element as minimum
Ex:- for 1 - [3, 1, 2, 4], for 2 - [2, 4] for 3 - [3] etc

Now how to find out the total possible subarrays from that maximum subarray :-

let's we have a subarray - [3, 1, 2, 4] - How to calculate all subarrays of [3, 1, 2, 4] such that 1 is included :-
Since 1 has to be included we will include 1 and we will have left slots and right slots to fill.
All subarrays = (left_slot)1_ (right_slot)

left_slot possibilites = (no. of elements to left of 1) + 1
(In the above example:- we have one element to the left of 1 - so we have two possibilites :-

we either include 3
we do not include anything
right_slot possibilites = (no. of elements to right of 1) + 1

we either include 2
we either include 2, 4
we do not include anything
Therefore total possible subarrays = left_slot possibilites * right_slot possibilites (Permutations and Combinations)

Now, we can use a monotonic stack to keep track of the left and right indicies of the maximum subarray that can be formed for each element with that element being the minimum.
"""
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = [-1]
        res = 0
        index = 0
        while index < len(arr):
            if len(stack) == 1 or arr[index] > arr[stack[-1]]:
                stack.append(index)
                index += 1
            else:
                cur_index = stack.pop()
                right_val = index - cur_index
                left_val = cur_index - stack[-1]
                # Permutations and Combinations
                res += right_val * left_val * arr[cur_index]

        while len(stack) > 1:
            cur_index = stack.pop()
            right_val = len(arr) - cur_index
            left_val = cur_index - stack[-1]
            res += right_val * left_val * arr[cur_index]

        return res % 1000000007