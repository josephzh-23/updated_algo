# this allows  you to find the index of key in array
# if the key belongs to array

def last(a, key):
    ans = -1;
    low = 0
    high = len(a) - 1

    while (low <= high):
        mid = low + ((high - low + 1) // 2);
        midVal = a[mid];

        if (midVal < key):

            # if mid is less than key, then all elements
            # in range [low, mid - 1] are also less
            # so we now search in [mid + 1, high]
            low = mid + 1;

        elif (midVal > key):

            # if mid is greater than key, then all
            # elements in range [mid + 1, high] are
            # also greater so we now search in
            # [low, mid - 1]
            high = mid - 1;

        elif (midVal == key):

            # if mid is equal to key, we note down
            # the last found index then we search
            # for more in right side of mid
            # so we now search in [mid + 1, high]
            ans = mid;
            low = mid + 1;

    return ans;
