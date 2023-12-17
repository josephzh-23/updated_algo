
"""
Using a 2 pointer apporach here
 people[i] has the weight of the ith person here each boat can carry 2 people
at the same time
 but the sum of these 2 people have to be at most limit as said

 O(nlogn)
 
"""
def savePeople(people, limit):
    people.sort()

    l, r = 0, len(people) -1
    boats =0

    # here we have used the left and right pointer
    while l < r:
        if people[l] + people[r] <= limit:
            l+=1
            r-=1

            # too heavy so we decrement the right
        else:
            r-=1
        # we still have to increase the boat here
        boats+=1
    return boats


people = [1, 2]; limit = 3




