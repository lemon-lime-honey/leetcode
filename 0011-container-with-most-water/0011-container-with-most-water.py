class Solution:
    def maxArea(self, height: List[int]) -> int:
        lo, hi = 0, len(height) - 1
        result = 0

        while lo < hi:
            result = max(result, (hi - lo) * min(height[lo], height[hi]))

            if height[lo] < height[hi]:
                lo += 1
            else:
                hi -= 1

        return result