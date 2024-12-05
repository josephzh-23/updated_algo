"""
Can check if sth is connected
isConnected[i][j] = 1 if ith and jth are connected here
isConnected[i][j] = 0 when not connected here
"""
from Graph.Union_set.unionCool import UnionCool


#
# practice problem you have seen before and keep practicing the same
def findFriends(isConnected):
    n = len(isConnected)
    s = UnionCool(n)

    num = n
    for i in range(n):
        for j in range(i + 1, n):
            if(isConnected[i][j] ==1 ):
                s.Union(i, j)
                num-=1
    return num
print(findFriends([[1, 0, 0], [0, 1, 0], [0, 0, 1]]))











