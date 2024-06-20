class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        lo, hi = 1, position[-1] - position[0]
        result = 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            cnt, now = 1, position[0]
            for p in position[1:]:
                if p - now >= mid:
                    cnt += 1
                    now = p
            if m <= cnt:
                result = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return result
