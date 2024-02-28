class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        piles.sort()
        lo, hi = 1, piles[-1]

        while lo < hi:
            mid = (lo + hi) // 2
            cnt = 0

            for pile in piles:
                cnt += pile // mid
                if pile % mid:
                    cnt += 1

            if cnt > h:
                lo = mid + 1
            else:
                hi = mid

        return lo