class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cnt = defaultdict(int)
        result = list()
        left = list()

        for num in arr1:
            cnt[num] += 1

        for num in arr2:
            for i in range(cnt[num]):
                result.append(num)
            cnt[num] = 0

        for key, value in cnt.items():
            for i in range(value):
                heapq.heappush(left, key)

        while left:
            result.append(heapq.heappop(left))

        return result