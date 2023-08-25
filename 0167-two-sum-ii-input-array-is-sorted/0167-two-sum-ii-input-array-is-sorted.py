class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        lo, hi = 0, len(numbers) - 1

        while lo < hi:
            temp = numbers[lo] + numbers[hi]
            if temp < target: lo += 1
            elif temp > target: hi -= 1
            else: return [lo + 1, hi + 1]