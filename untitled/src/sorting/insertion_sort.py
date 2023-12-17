

"""
Worst : O(N^2)
best linear O(N)

"""

# insertion sort this actually can sort here 
def sort(array):
    for i in range(len(array)):

        cur = array[i]
        j = i -1
        while (j >= 0 and array[j] > cur ):

            # we keep shifting the higher number to the back here
            # for every single one here
            array[j + 1] = array[j]
            j-= 1

        array[j+ 1] = cur

arr = [1, 2, 5, 3, 4]
sort(arr)
print(arr)