
"""
Use a sliding window technique here

2 possible cases

There are two possible cases.

Case 1. p*x < k
This means we can move the window’s right bound one step further. How many contiguous arrays does this step produce?
It is: 1 + (end-start).
Indeed, the element itself comprises an array,
 and also we can add x to all contiguous arrays which have right border at end.
 There are as many such arrays as the length of the window.

 Case 2. p*x >= k
This means we must first adjust the window’s left border so that the product is again less than k. After that,
 we can apply the formula from Case 1.
"""


# Python3 program to count
# subarrays having product
# less than k.


def countSubArrayProductLessThanK(a, k):
    n = len(a)
    p = 1
    res = 0
    start = 0
    end = 0
    while(end < n):

        # Move right bound by 1
        # step. Update the product.
        p *= a[end]

        # Move left bound so guarantee
        # that p is again less than k.
        while (start < end and p >= k):
            p = int(p//a[start])
            start += 1

        # If p is less than k, update
        # the counter. Note that this
        # is working even for (start == end):
        # it means that the previous
        # window cannot grow anymore
        # and a single array element
        # is the only addendum.
        if (p < k):
            l = end - start + 1
            res += l

        end += 1

    return res


# Driver Code
if __name__ == '__main__':
    print(countSubArrayProductLessThanK([1, 2, 3, 4], 10))
    print(countSubArrayProductLessThanK([1, 9, 2, 8, 6, 4, 3], 100))
    print(countSubArrayProductLessThanK([5, 3, 2], 16))
    print(countSubArrayProductLessThanK([100, 200], 100))
    print(countSubArrayProductLessThanK([100, 200], 101))

# This code is contributed by mits





