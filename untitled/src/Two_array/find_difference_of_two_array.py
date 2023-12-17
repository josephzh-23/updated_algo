"""
Given 2 arrays nums1 and nums2
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

Example:
    nums1 = [1, 2, 3]
    nums2 = [2, 4, 6]
    [[1, 3], [4, 6]]
"""
from typing import Any



# this can be used everywhere
def size(self):
    return range(len(self))

def ans(nums1, nums2):
    ans = []
    s1 = set()
    s2 = []
    for i in size(nums1):
        s1.add(nums1[i])

    for j in size(nums2):
        print(nums2[j])
        if nums2[j] in s1:
            s1.remove(nums2[j])
        else:
            s2.append(nums2[j])
    ans.append(s1)
    ans.append(s2)
    print(ans)
ans([1, 2, 3], [2, 4, 6])








