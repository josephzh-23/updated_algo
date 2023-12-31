"""
Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
output : 15 as said

# may not load more than the max weight capacity here
 want to find the minimum capacity to ship all things
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Steps:
1. ans to store the resultant min capacity of the boat required, -1

2. Initialize two variables, say s and e with the maximum element in the given array
and the total sum of the array respectively which denotes the lower
 and upper bounds of the search space.

 3. mid = (s + e) /2
 Check if it is possible to ship all the packages within D days when the maximum
 capacity allowed is mid.
    - If found to be true, then update the value of ans to mid and the value of e to (mid – 1).
    - Otherwise, update the value of s to (mid + 1).
"""


# Function to check if the weights
# can be delivered in D days or not
def isValid(weight, n, D, mx):
    # Stores the count of days required
    # to ship all the weights if the
    # maximum capacity is mx
    st = 1
    sum = 0

    # Traverse all the weights
    for i in range(n):
        sum += weight[i]

        # If total weight is more than
        # the maximum capacity
        if (sum > mx):
            st += 1
            sum = weight[i]

        # If days are more than D,
        # then return false
        if (st > D):
            return False

    return True


# Function to find the least weight
# capacity of a boat to ship all the
# weights within D days
def shipWithinDays(weight, D, n):

    #store total weights to be shipped here
    sum =0
    for i in range(n):
        sum+= weight[i]

    # Stores the maximum weight in the array that has to be shipped
    s = max(weight)

    # e will store the total sum which can only be our maximum as said 
    # Store the ending value for
    # the search space
    e = sum

    #store the required result
    res = -1

    # Perform binary search
    while (s <= e):

        # Store the middle value
        mid = s + (e - s) // 2

        # If mid can be shipped, then
        # update the result and end
        # value of the search space
        if (isValid(weight, n, D, mid)):
            res = mid
            e = mid - 1

        # Search for minimum value
        # in the right part
        else:
            s = mid + 1

    # print the result
    print(res)


# Driver Code
if __name__ == '__main__':

    weight = [ 9, 8, 10 ]
    D = 3
    N = len(weight)

    shipWithinDays(weight, D, N)












