class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if m * k > len(bloomDay): return -1
        lo, hi = 1, int(1e9)

        while lo < hi:
            mid = lo + (hi - lo) // 2
            flower, bouquet = 0, 0
            for day in bloomDay:
                if mid < day:
                    flower = 0
                else:
                    flower += 1
                if k <= flower:
                    flower = 0
                    bouquet += 1
                    if bouquet == m: break
            if bouquet == m:
                hi = mid
            else:
                lo = mid + 1

        return lo