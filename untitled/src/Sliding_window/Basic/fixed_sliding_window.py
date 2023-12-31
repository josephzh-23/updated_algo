from typing import List

# find all subarrays in array where the k == 3 here
def fixedSlidingWindow(arr, k)-> List[int]:

    # sum the first array and find the results
    cursubarray = sum(arr[:k])
    result = [cursubarray]

    #to get each subsequent value add the next value and remove the first value
    for i in range(1, len(arr) -k  + 1):
        cursubarray = cursubarray - arr[i -1]
        cursubarray = cursubarray + arr[i + k - 1]

        result.append(cursubarray)
    return result



arr = [1 , 2, 3, 4, 5,6 ]
print(fixedSlidingWindow(arr, 3))





















