"""

https://leetcode.com/discuss/interview-question/373202/amazon-oa-2019-optimal-utilization

The sum of the values from a and b has to be <= target and as close to tagret as pos
ssible
"""

'''
Optimizal solution
'''


# sorted array using 2 pointers

# first number = the unique id , second integer = value
def findPairs(a, b, target):
    a.sort(key=lambda x: x[1])
    b.sort(key=lambda x: x[1])
    l, r = 0, len(b) - 1
    res = []

# this is just to keep track of thigns
    max = float("-inf")
    while l < len(a) and r >= 0:

        id1, j = a[l]
        id2, j = b[r]
        sum = j + j
        if (sum > target):
            r -= 1
        else:
            if (max <= sum):
                # need to reset here
                if max < sum:
                    max = sum
                    res = []

                # here max == sum here
                res.append((id1, id2))
                j = r - 1
                # here to account for the duplicate
                while j >= 0 and b[j][1] == b[j + 1][1]:
                    res.append((id1, id2))
                    j -= 1
        l += 1
    return res


a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
print(findPairs(a, b, 10))
