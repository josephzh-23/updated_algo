

# so to get the max score we just have to make sure to keep a sliding window
# of minimum score for the sliding window
def maxScore(cardpoints, k):
    n = len(cardpoints)
    start, end, cursum = 0, 0, 0
    subarrayscore = 0

    # use the sliding window to find subarray size cardpoints.length - k that
    # has minimal sum
    requiredsubarraylen = n - k
    totalscore = sum(cardpoints)

    minsubarrayscore = totalscore

    #extend the sliding window until criteria is met
    for end in range(n):
        subarrayscore += cardpoints[end]
        cursubarraylen = end - start + 1


        # if having a subarray having ( cardpoints.size - k ) is possible
        # we contract the window here
        if(cursubarraylen == requiredsubarraylen):
            minsubarrayscore = min(minsubarrayscore, subarrayscore)
            subarrayscore -= cardpoints[start]
            start+=1
    return totalscore - minsubarrayscore












