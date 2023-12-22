
"""
Here we would ahve [10, 60] where you can go to
[20, 80]    [30, 70]    [60, 50]        startFuel = 10

Bsaically we can get the max distance that can be travelled at each stop
0       max distance
1       70
2       110
"""
import heapq
from queue import PriorityQueue


# stations: [[]]   a 2d array here


h = heapq
def minRefuelStops(target, startFuel, stations):
    n = len(stations)
    pq = []  # max q
    h._heapify_max(pq)
    refill, i = 0, 0
    dist = startFuel


    while(dist < target):
        # At each stop we just let things go as far away as possible here
        while( i < n and dist >= stations[i][0]):
            h.heappush(pq, stations[i])
            i+=1

        if not pq: return -1
        dist += h._heappop_max(pq)[1]
        refill+=1

    return refill


target = 100; startFuel = 10
stations = [[10, 60], [20, 30], [30, 30],
            [60, 40]]
print(minRefuelStops(100, 10, stations))
"""
 We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.


"""















