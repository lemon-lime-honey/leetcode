class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True

        start, end = 1, num // 2

        while start <= end:
            mid = (start + end) // 2
            target = mid * mid
            if num % mid == 0 and num == target:
                return True
            if num < target:
                end = mid - 1
            else:
                start = mid + 1

        return False
