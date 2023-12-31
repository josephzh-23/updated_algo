# remove the duplicates in place here

def removeDuplicates(arr):


    # 1 pointer for iterating
    i = 1

    # 1 pointer for placing the next nonduplicate
    nextnondupe = 1

    while ( i < len(arr)):
        if arr[nextnondupe - 1] != arr[i]:
            arr[nextnondupe] = arr[i]
            nextnondupe+=1
        i+=1

    return nextnondupe

















