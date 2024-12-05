

# this prints all the permutation of
"""
abc
abc, acb, bac, bca, cba, cab
"""
# the arr here woudlb an array here
#using backtracking here
def permute(charArray, l, r):
    if l == r:
        print(''.join(charArray))

    for i in range(l, r):
        charArray[l], charArray[i] = charArray[i], charArray[l]
        permute(charArray, l + 1, r)
        charArray[l], charArray[i] = charArray[i], charArray[l]


permute(list("abc"), 0, len("abc"))



