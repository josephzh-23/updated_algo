

'''

Is there a simpler approach? What if we iterate from right to left? In that scenario,
 we have to keep track of the largest digit encountered so far
  and then swap it with right-most digit which is smaller than it.

  Find left most largest digit and replace it with the right most smallest digit
'''
def maxSwap(num: int):

    numlist = list([int(c) for c in str(num)])

    lastindex = {n: i for i, n in enumerate(numlist) }

    for i , n in enumerate(numlist):
        for d in range(9, n, -1):
            if d in lastindex and lastindex[d] > i:
                numlist[i], numlist[lastindex[d]] = numlist[lastindex], numlist[i]


                return int(''.join(str(d) for d in numlist))

        return num











