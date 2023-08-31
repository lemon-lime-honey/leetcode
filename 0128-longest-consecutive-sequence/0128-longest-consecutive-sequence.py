import heapq


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        heapq.heapify(nums)
        chk = [0, 0, 0]

        while nums:
            now = heapq.heappop(nums)
            if chk[2] == 0:
                chk = [now, 1, 1]
            else:
                if now == chk[0] + 1:
                    chk[0] = now
                    chk[1] += 1
                    chk[2] = max(chk[2], chk[1])
                elif now == chk[0]: continue
                else:
                    chk[0] = now
                    chk[1] = 1

        return chk[2]