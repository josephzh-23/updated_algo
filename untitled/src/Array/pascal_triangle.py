

# return the number of row of pascal triangle
"""
    0 [1, 2, 1] 0
 0 [1 , 3,  3, , 1] 0

"""
from typing import List


def generate(numRows:int) -> List[List[int]]:
    res = [[1]]

    # here if 5 then we can only go up to 5 here
    for i in range(numRows - 1):

        temp = [0] + res[-1] + [0]
        print("temp is ", temp)
        row = []
        print("length is ", len(res[-1]))
        for j in range(len(res[-1]) + 1):
            row.append(temp[j] + temp[j+ 1])
        res.append(row)

    return res



generate(5)

