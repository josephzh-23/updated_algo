"""
All nodes distance k from the graph node
each pointer : an undriected edge

2. In the graph, recursively vist all unvisited neighboring nodes of cur node
3.
"""
import collections


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def distanceK(s, root: TreeNode, target: TreeNode, k):
    graph = collections.defaultdict(list)


    #Build the undirected edge rigth here
    def build_graph(cur, parent):
        if cur and parent:

            # add current and parent
            graph[cur.val].append(parent.val)
            graph[parent.val].append(cur.val)
        if cur.left:
            build_graph(cur.left, cur)
        if cur.right:
            build_graph(cur.right, cur)
    build_graph(root, None)

    answer = []

    visited = set([target.val])
    def dfs(cur, distance):
        if distance == k:
            answer.append(cur)
            return

        # visit all the children of the node in the graph here
        for neighbor in graph[cur]:
            if neighbor not in visited:
                visited.add(neighbor)
                dfs(neighbor, distance + 1)
    dfs(target.val, 0)

    return answer





