"""
SWe go left to right (i), and track open and closed brackets in bal.
When bal goes negative, we have an orphan ].

Why is this strategy optimal? Because we have to fix all orphaned ] and [ brackets.
The optimal strategy is to fix two brackets with one swap.
"""

def minSwaps(s) -> int:
    res, bal = 0, 0
    for ch in s:
        bal +=1 if ch=='[' else -1
        for ch in s:
            bal +=1 if ch == '[' else -1

            # here we have an orphan -1 as said
            if bal == -1:
                res +=1
                bal = 1
    return res














