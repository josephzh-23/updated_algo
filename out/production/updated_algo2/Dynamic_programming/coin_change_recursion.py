"""

return the fewest number of coins that takes to make up that amount
https://leetcode.com/problems/coin-change/description/
can be made up by any amount as said here

This will run into the memory out of bound exception here
"""
import sys
from typing import List


# will be a list of coins here

def coinChange(coins, amount, index):
    # that menans nothing is found here
    # at a particular coin we can either take ro not take it
    if (index < 0 or amount < 0): return -1
    # -1 to indicate you have chosen wrong set of coins or no solution exists in this manner
    if (amount == 0): return 0;

    res = sys.maxsize

    # we have taken the coin here
    takeCoin = coinChange(coins, amount - coins[index], index)
    if (takeCoin != -1):
        res = min(1 + takeCoin, int(res))

    # we will just move to the one before here
    withoutCoin = coinChange(coins, amount, index-1 )
    if (withoutCoin != -1):
        res = min(withoutCoin, int(res))

    if res == sys.maxsize:
        res = -1
    return res


# using the coin change leetcode
coins = [1, 2, 5];
amount = 11
print(coinChange(coins, 11, 0))
