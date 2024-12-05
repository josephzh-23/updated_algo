"""

The question here is
Input: nums1 = [-2, -1, 3, 5, 6, 8], nums2 = [0, 1, 2, 5, 9], k = 4
Output: 5
Explanation: Union of above arrays will be [-2, -1, 0, 1, 2, 3, 5, 5, 6, 8, 9]
and the 4th largest element is 5.


"""
import sys


# can use a 2 pointer solution here


def kthLargest(nums1, nums2, k):
    n1, n2 = len(nums1), len(nums2)

    if n1 + n2 < k:
        return float('inf')

    i = n1 - 1
    j = n2 - 1
    cur = sys.maxsize

    while k > 0 and i >= 0 and j >= 0:
        if nums1[i] > nums2[j]:
            cur = nums1[i]
            i -= 1
        elif nums2[j] > nums1[i]:
            cur = nums2[j]
            j -= 1
        k -= 1
    print("the k is ", k)
    if k == 0:
        return cur
    elif i < 0:
        return nums2[j - k + 1]
    else:
        return nums1[i - k + 1]

