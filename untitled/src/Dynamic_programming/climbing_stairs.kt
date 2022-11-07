package Dynamic_programming

/*
  if n = 5
  need to store the data inside somewhere as discussed from 0
  each time we get to 5
 1. Use recursino with DFS    O(N): 2^n   n height of the tree
 2. SOme tree might look the same as otehr tree as explained

 Start at the base case and work our way up
 Store results in an array      so if index = 5
 start at 5,
 From 4-5   1 step          from 3-5    2 step

   so the result[i] = result[i+1] + result[i+2] it would seem here
 Index    0   1    2   3   4    5
  DP      8   5    3   2   1    1
*/