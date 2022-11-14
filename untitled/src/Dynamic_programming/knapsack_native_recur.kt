package Dynamic_programming
/*
O ( 2 ^n)
This is the slow approach as dicsussed
So we start from the back of the array as discussed
def ks(n, c):

    v[n]       the value array
// nothing left to return because no more capacity
    if n ==0 or c ==0: // base case
        result = 0

    if cur wt > c , then move to left
    else if w[n] > c:
        result = ks(n-l, c)

        case3: try uptting item in knapsack and not putting
        it there with tmp1 and tmp2 and check the maximum result
        tmp1 -> !put in ksack
        tmp2 -> put in sack, we will add v[n] curr item value
    else:
        tmpI = ks(n-1, c)
        tmp2 = v[n] + ks(n-1, c- w[n])
        result = max(tmp1, tmp2)

 */