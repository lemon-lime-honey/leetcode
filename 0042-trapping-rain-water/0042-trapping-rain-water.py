class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0

        lo, hi = 0, len(height) - 1
        maxL, maxR = height[lo], height[hi]
        result = 0

        while lo < hi:
            if maxL < maxR:
                lo += 1
                maxL = max(maxL, height[lo])
                result += max(0, maxL - height[lo])
            else:
                hi -= 1
                maxR = max(maxR, height[hi])
                result += max(0, maxR - height[hi])

        return result