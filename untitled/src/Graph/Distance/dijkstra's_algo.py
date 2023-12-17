import sys
from queue import PriorityQueue


'''
Using this we basically printed out the shortest path for each of the node down here
'''
class Graph:
    # all the vertex here
    def __init__(s, V):
        s.V = V
        s.adj = [[] for i in range(V)]

    def addEdge(s,u , v, w):
        # this will be like pair down here
        s.adj[u].append((v, w))
        s.adj[v].append((u, w))

    def shortestPath(s, src):
        pq = PriorityQueue()
        dist = [sys.maxsize] * s.V

        #this is for starting here
        dist[src] = 0
        pq.put(Node(src, 0))
        while pq.qsize() > 0:
            u = pq.get().vertex

            for neigh in s.adj[u]:
                v = neigh[0]
                distance = neigh[1]

                # relaxation step from u to get to v
                if(dist[v] > dist[u] + distance):
                    dist[v] = dist[u] + distance
                    pq.put(Node(v, dist[v]))

        #and then print the shortest path here
        for i in range(s.V):
            print("vertex is ", dist[i])

'''
S here is the starting node as said 
'''
class Node:
    """
    Here v is the vertex and d is the distance here
    """

    def __init__(s, vertex, distance):
        s.vertex = vertex
        s.distance = distance

    # define a comparator in python
    def __lt__(s, other):
        return s.distance < other.distance

    # fxn to implement Dikjstra's algo to find shortest path, v being the size here



# init adj list and map here
map = {}
# of vertices and edges
V = 6
E = 5

g = Graph(9)
g.addEdge(0, 1, 4)
g.addEdge(0, 7,8)
g.addEdge(1, 2, 8)
g.addEdge(1, 7, 11)
g.addEdge(2, 3, 7)
g.addEdge(2, 8, 2)
g.addEdge(2, 5,4 )
g.addEdge(3, 4, 9)
g.addEdge(3, 5, 14)
g.addEdge(4, 5, 10)
g.addEdge(5, 6, 2)
g.addEdge(6, 7, 1)
g.addEdge(6, 8, 6)
g.addEdge(7, 8, 7)

g.shortestPath(0)










