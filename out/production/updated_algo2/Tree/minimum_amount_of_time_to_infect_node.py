from Tree.Basic.inorder import Node

# fxn for building parent - root relation

# use an array to init all the nodes here



#
parent = [None] * 10005
startingnode: Node

# used to build all the parent in the picture here
def findParent(root, p, start):
    if not root:
        return

    parent[root.val] = p
    if root.val == start:
        global startingnode
        startingnode = root
    findParent(root.left, root, start)
    findParent(root.right, root, start)

def amountofTime(r, start):
    findParent(r, None, start)

    visited = [False] * 10005

    q= []
    q.append(startingnode)
    visited[start] = True

    #stores the min time to infect all nodes
    while len(q) > 0:
        n= len(q)
        for i in range(n):
            curr = q.pop(0)
            curnode = curr.val
            """
            what we need to do here is check if the parent of curnode 
            exists and not visited yt, then push parent[curnode] into q
    """
            parentnode = parent[curnode]

            if parentnode and not visited[parentnode.val]:
                visited[parentnode.val] = True
                q.append(parent[curnode])

            #check if cur node left child exists and not visited yet

            # Check if current node left
            # child exist and not
            # visited yet.
            if curr.left and not visited[curr.left.val]:
                visited[curr.left.val] = True
                q.append(curr.left)

            # Check if current node right
            # child exist and not
            # visited yet.
            if curr.right and not visited[curr.right.val]:
                visited[curr.right.val] = True
                q.append(curr.right)
