from typing import List

"""
Draw exactly k cards form array so score maximized
2. After drawing k cards from the array 
cardPoints.length - k cards will remain in the array.

3. Can also make sure that the sum is minimized when choosing cards from the 
beginning / end of the array 

4. presentSubarrayScore = the present score 

5. Check the size that it's the same 

"""

def maxPointsFromCard(cardPoints: List[int], k: int):
    # a sum of points here

    n = len(cardPoints)
    prefix = [0] * n     # prefix

    for i in range(1, n):
        prefix[i] = prefix[i-1] + cardPoints[i]


    print(prefix)





maxPointsFromCard([1, 2, 3, 4, 5, 6, 1], 3)







