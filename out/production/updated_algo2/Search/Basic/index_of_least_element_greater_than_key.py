

# index of least element > key there

# Find index of first occurrence of least element
# greater than key in array
# Returns: an index in range [0, n-1] if key is not
# the greatest element in array,
# -1 if key is the greatest element in array */
def leastgreater(a, low, high, key):
    ans = -1;

    while (low <= high):
        mid = low + ((high - low + 1) // 2);
        midVal = a[mid];

        if (midVal < key):

            # if mid is less than key, all elements
            # in range [low, mid - 1] are <= key
            # then we search in right side of mid
            # so we now search in [mid + 1, high]
            low = mid + 1;

        elif (midVal > key) :

            # if mid is greater than key, all elements
            # in range [mid + 1, high] are >= key
            # we note down the last found index, then
            # we search in left side of mid
            # so we now search in [low, mid - 1]
            ans = mid;
            high = mid - 1;

        elif (midVal == key) :

            # if mid is equal to key, all elements in
            # range [low, mid] are <= key
            # so we now search in [mid + 1, high]
            low = mid + 1;

    return ans;