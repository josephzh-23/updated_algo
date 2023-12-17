import heapq
from queue import PriorityQueue

# same as a priority queue
h = heapq

q = []
h.heapify(q)
h.heappush(q, -1 * 4)
h.heappush(q, -1 * 6)
h.heappush(q, -1 * 7)

# must multiply a value by -1 when doing the pop
print(-1 * h.heappop(q))

q = PriorityQueue()
q.put((0, 4))
q.put((50, 4))
q.put((-1, 4))
print(q.get())
print(q.get())