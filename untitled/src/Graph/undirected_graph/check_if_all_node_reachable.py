# Python code for the above approach:

# Function to find if
# all nodes can be visited from X
def canVisitAllNodes(arr, X, n):
    q = []
    visited = [False]*n
    q.append(X)
    visited[X] = True
    count = 0

    # Loop to implement BFS
    while(len(q) > 0):
        size = len(q)

        for i in range(size):
            curr = q.pop(0)

            count = count + 1

            for j in arr[curr]:
                if(visited[j] == False):
                    q.append(j)
                    visited[j] = True

    # Check if all nodes are visited
    if(count == n):
        return True

    return False

# Driver code
arr = [[1, 2], [0, 3, 2], [0, 1], [1]]
N, X = 4, 0

# Function Call
if(canVisitAllNodes(arr, X, N)):
    print("YES")
else:
    print("NO")

# This code is contributed by Pushpesh Raj.