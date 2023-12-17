from collections import deque
from typing import List


#generate all the children for that lock here
def children(lock):
    res = []
    for i in range(4):
        nextDigit = str(int(lock[i] + 1) %10)
        res.append(lock[:i] + nextDigit  + lock[i +1:])
        digitBefore= int(lock[i] - 1 + 10) %10
        res.append(lock[:i] + digitBefore + lock[i+ 1:])
    return res


# return the number of locks that's requried here
def openLock(deadends: List[str], target: str):
    if "0000" in deadends:
        return -1

    q = deque()
    q.append(["0000", 0])       #[lock , turns]
    visited = set()

    while q:
        lock, turns = q.pop()
        if lock == target:
            return turns
        for child in children(lock):
            if(child not in deadends and child not in visited):
                q.append([child, turns + 1])
                visited.add(child)

    return -1