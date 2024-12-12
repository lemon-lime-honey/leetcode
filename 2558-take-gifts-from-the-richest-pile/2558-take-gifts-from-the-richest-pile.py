class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        hq = list()

        for gift in gifts:
            heapq.heappush(hq, -gift)

        for i in range(k):
            now = -heapq.heappop(hq)
            heapq.heappush(hq, -(int(now ** 0.5)))

        return -sum(hq)