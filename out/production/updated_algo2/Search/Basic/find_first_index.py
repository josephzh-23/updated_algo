

def first(array, target):
    ans = -1
    low, high = 0, len(array) -1
    while (low <= high):
        mid = (high + low) // 2
        midVal = array[mid]

        if (midVal < target):
            # if mid is less than key, all elements
            # in range [low, mid] are also less
            # so we now search in [mid + 1, high]
            low = mid + 1

        elif (midVal > target):
            # if mid is greater than key, all elements
            # in range [mid + 1, high] are also greater
            # so we now search in [low, mid - 1]
            high = mid - 1

        elif (midVal == target):
            # if mid is equal to key, we note down
            #  the last found index then we search
            # for more in left side of mid
            # so we now search in [low, mid - 1]
            ans = mid
            high = mid - 1

    return ans

