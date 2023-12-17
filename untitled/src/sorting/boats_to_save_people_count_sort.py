"""'
Can do even better with count sort here
"""

def numBoats(people, limit):

    count = [0] * (limit + 1)
    for p in people:
        count[p] += 1

    index = 0

    for val in range(1, limit):
        while(count[val] > 0):
            people[index] = val
            index+=1
            count[val] -=1











