import heapq



class MaxHeap():
    def __init__(self):
        self.heap = []
        heapq._heapify_max(self.heap)

    def add(self, value):
        heapq.heappush(self.heap, value)
        heapq._heapify_max(self.heap)

    def pop(self):
        if len(self.heap) == 0:
            return None
        output = heapq.heappop(self.heap)
        heapq._heapify_max(self.heap)
        return output

    def top(self):
        return self.heap[0] if len(self.heap) else None

    def get_heap(self):
        return self.heap
s = MaxHeap()
s.add(4)
s.add(12)
s.add(18)
print(s.pop())
