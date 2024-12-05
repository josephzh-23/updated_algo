"""
The most basic form for this algorithm is here

1. Store  min time to reach from 0 to nth node

2 cases:

The first type is less than the first
If (time[u] + time_taken(u, v) < time[v])  , then ways[v] = ways[u]

we have a match
If (time[u] + time_taken(u, v) == time[v]), then ways[v] = ways[v] + ways[u]

"""