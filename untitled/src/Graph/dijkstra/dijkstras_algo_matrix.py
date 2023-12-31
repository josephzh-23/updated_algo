from queue import PriorityQueue

from Graph.Basics.bfs_matrix_python import areIndexValid
from Graph.Hard.shortest_distance_to_all_buildings import directions



# start point is [start[point[0]], start[point[1]]
def findShortestPath(graph, start):

    visited = [[False for col in row] for row in graph]

    # a 2 d
    distance = [[float('inf') for col in row] for row in graph]
    startx = start[0]
    starty = start[1]

    # stores the previos pt taken to get to this point here
    prevpoint = [[None for col in row] for row in graph]

    n, m = len(graph), len(graph[0])

    numOfPoints ,visitedCount = n*m, 0

    q = PriorityQueue()
    q.put(distance[startx][starty], startx, starty)


    #min heap item format

    while visitedCount < numOfPoints:
        curpoint = q.get()


        distanceFromStart, row, col = curpoint
        for direction in directions:
            newrow, newcol = row + direction[0], col + direction[1]
            if areIndexValid(graph, newrow, newcol) and not visited[newrow][newcol]:

                distanceToNewPoint = distanceFromStart + graph[newrow][newcol]
                if distanceToNewPoint < distance[newrow][newcol]:
                    distance[newrow][newcol] = distanceToNewPoint
                    prevpoint[newrow][newcol] = (row, col)

                    q.put(distanceToNewPoint, newrow, newcol)
        visited[row][col]= True
        visitedCount+=1
    return distance, prevpoint






def find_shortest_path(prev_point_graph, end_point):
    shortest_path = []
    current_point = end_point
    while current_point is not None:
        shortest_path.append(current_point)
        current_point = prev_point_graph[current_point[0]][current_point[1]]
    shortest_path.reverse()
    return shortest_path
















