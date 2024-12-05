from collections import deque
from typing import List

from Graph.Basics.bfs_matrix_python import areIndexValid

'''

Step 1: start from a house and find all reachable empty lands 
since fewer houses than empty lands, so this approach will require less 
time here 

2.
 Would be generating partial distance (dist from 1 house to the cur cell)
Would be storing 2 values at each cell position of empty cell 
Pair ( total distance sum from all houses to this empty land,
 number of houses that can reach this empty land)
 
 3. Steps
 For each house cell (grid[i][j] equals 1), start a BFS:
For each empty cell we reach, increase the cell's sum of distances by the steps taken to reach the cell.
For each empty cell we reach, also increment the cell's house counter by 1.

4. 
After traversing all houses, get the minimum distance from all empty cells
 which have housesReached equal to totalHouses.

5. If it is possible for all houses to reach a specific empty land cell,
 then return the minimum distance found. Otherwise, return -1.

'''
directions = [(1,0), (-1, 0), (0, 1), (0, -1)]
#https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
def shortestDistance(grid: List[List[int]])-> int:
    rows = len(grid)
    cols = len(grid[0])

    # keep a distnace matrix for this
    distMatrix = [[0] * cols for row in range(rows)]
    print(distMatrix)

    building = 1
    obstacle = 2
    emptyLand = 0
    minDist = float('inf')

    # each 0 marks an empty land here that you pass by

    for row in range(rows):
        for col in range(cols):

            # step 1: start a bfs from a building
            if grid[row][col] == building:
                localDist = 0


                q = deque([(row, col, 0)])

                while q:
                    curRow, curCol, distance = q.popleft()

                    for dx, dy in directions:
                        newRow = curRow + dx
                        newCol = curCol + dy

                        if (areIndexValid(grid, newRow, newCol) and grid[newRow][newCol] == emptyLand):
                            grid[newRow][newCol] -=1
                            distMatrix[newRow][newCol] += distance +1






