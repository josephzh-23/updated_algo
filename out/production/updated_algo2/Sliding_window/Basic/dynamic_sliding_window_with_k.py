"""
diff between max and min avg of all k-length conti subarrays
Input: arr[ ] = {3, 8, 9, 15}, K = 2
Output: 6.5
Explanation:
All subarrays of length 2 are {3, 8}, {8, 9}, {9, 15} and their averages are (3+8)/2 = 5.5,
 (8+9)/2 = 8.5, and (9+15)/2 = 12.0 respectively.
Therefore, the difference between the maximum(=12.0) and minimum(=5.5) is 12.0 -5.5 = 6.5.
"""



def solution(arr, k):
    # find sum up to k
    n = len(arr)
    cursum = sum(arr[:k])
    print("cursum is ", cursum)
    mini, maxi = cursum, cursum

    for i in range(k, n - k + 2):
        cursum += arr[i] - arr[i- k]
        mini = min(mini, cursum)
        maxi = max(maxi, cursum)

    return (maxi - mini)/ k

arr = [3, 8, 9 ,15]
n = len(arr); k = 2
print(solution(arr, k))












