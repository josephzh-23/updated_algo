'''

Given a directed and weigthed grpah of N ndoes
between node 1 to n find the answer here

Input: N = 4, M = 5, edges = {{1, 4, 5}, {1, 2, 4}, {2, 4, 5}, {1, 3, 2}, {3, 4, 3}}

The problem can be solved using dijkstra's algorithm here
- dist[] to store shortest distance from source vertex

- paths[] of size N to store # of different shortest path from source vertex to vertex
N

1. Initialize a priority queue, say pq, to store the vertex number and its distance value.
2. Init a vector of 0s here and then make path[1] = 1
'''
from collections import defaultdict


INF = int(1e9)
from queue import PriorityQueue
edges = [(1, 4, 5),
         (1, 2, 4), (2, 4, 5), (1, 3, 2), (3, 4, 3)]
INF = int(1e9)
MAXN = int(1e5 + 1)

# A function to count the number of shortest paths from node 1 to node N
def countDistinctShortestPaths(n, m, edges):
    # Storing the graph using adjacency list
    g = defaultdict(list)
    for i in range(m):
        node, neigh, distance = edges[i]
        g[node].append((neigh, distance))

    # Initializing the distance array to a large value
    dist = [INF] * (n + 1)

    # Initializing the count array to store the number of shortest paths
    route = [0] * (n + 1)

    # Base Cases
    dist[1] = 0
    route[1] = 1

    # Initialize a priority queue
    pq = PriorityQueue()
    pq.put((0, 1))

    # Loop while priority queue is not empty
    while not pq.empty():
        lastDistance, node = pq.get()

        # if d is greater than distance of the node
        if lastDistance > dist[node]:
            continue

        # Traversing all its neighbours
        for neigh, distance in g[node]:
            if distance + lastDistance > dist[neigh]:
                continue

            # Path found of same distance
            if distance + lastDistance == dist[neigh]:
                route[neigh] += route[node]

            # New path found for lesser distance
            if distance + lastDistance < dist[neigh]:
                dist[neigh] = distance + lastDistance
                route[neigh] = route[node]

                # Pushing in priority queue
                pq.put((dist[neigh], neigh))

    # Return the number of shortest paths from node 1 to node N
    return route[n]


