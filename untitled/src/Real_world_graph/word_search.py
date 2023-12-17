from typing import List

from Graph.Basics.bfs_matrix_python import areIndexValid

'''
O (n * m * 4^n)

always making 4 decisions here 
'''
def exist(board: List[List[str]], word: str)-> bool:
    rows, cols = len(board), len(board[0])
    path = set()

    # the meat here
    def dfs(r, c, i)-> bool:
        # this is found the case
        if i == len(word):
            return True

        if (not areIndexValid(board, r, c) or word[i]!= board[r][c] or
                (r, c) in path):
            return False

        path.add((r, c))

        # this is the typical backtrakc here
        res = (dfs(r+ 1, c, i+ 1)) or(dfs(r-1, c, i+ 1)) \
              or dfs(r, c + 1, i + 1) or dfs(r, c-1, i + 1)

        path.remove((r, c))
        return res


    # only start traversing when you see a 0 here
    for r in range(rows):
        for c in range(cols):
            if dfs(r, c, 0): return True
    return False
