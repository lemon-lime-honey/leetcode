class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        que = list()
        result = [None for i in range(len(score))]
        message = {0: 'Gold Medal', 1: 'Silver Medal', 2: 'Bronze Medal'}

        for i in range(len(score)):
            heapq.heappush(que, (-score[i], i))

        for i in range(len(score)):
            if i in message:
                result[heapq.heappop(que)[1]] = message[i]
            else:
                result[heapq.heappop(que)[1]] = str(i + 1)

        return result