package Dynamic_programming

/* O(n *c)

storing results in 2d array n *c

def ks(n, c):       only n*c # of possibilities that we can have
    if arr[n][c] !=undefined
    return arr[n][c]

    if n==0 or c==0:    //base case
        result = 0
    else if w[n] > c:
        result = Ks(n - 1, c)
    else:
        tmp1 = ks(n-1, c)
        tmp2 = v[n] = ks(n-1, C- w[n])
        result = max(tmp1, tmp2)
    arr[n][c] = result
    return result
 */