class SmallestInfiniteSet:
    def __init__(self):
        self.heap = list()
        self.isIn = set()
        self.smallest = 1


    def popSmallest(self) -> int:
        if self.heap and self.heap[0] < self.smallest:
            target = heapq.heappop(self.heap)
            self.isIn.discard(target)
            return target
        self.smallest += 1
        return self.smallest - 1


    def addBack(self, num: int) -> None:
        if self.smallest > num and num not in self.isIn:
            heapq.heappush(self.heap, num)
            self.isIn.add(num)