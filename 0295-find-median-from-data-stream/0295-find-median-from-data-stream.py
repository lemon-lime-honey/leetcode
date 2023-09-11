import heapq


class MedianFinder:
    def __init__(self):
        self.one = list()
        self.two = list()


    def addNum(self, num: int) -> None:
        if len(self.one) == len(self.two):
            heapq.heappush(self.one, (-num, num))
        else:
            heapq.heappush(self.two, (num, num))
        if self.two and self.two[0][1] < self.one[0][1]:
            n1 = heapq.heappop(self.one)[1]
            n2 = heapq.heappop(self.two)[1]
            heapq.heappush(self.one, (-n2, n2))
            heapq.heappush(self.two, (n1, n1))


    def findMedian(self) -> float:
        if len(self.one) == len(self.two):
            return (self.one[0][1] + self.two[0][1]) / 2
        return self.one[0][1]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()