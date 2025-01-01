class Solution:
    def maxScore(self, s: str) -> int:
        left, right, result = 0, s.count("1"), 0

        for i in range(len(s) - 1):
            match s[i]:
                case "0":
                    left += 1
                case "1":
                    right -= 1
            result = max(result, left + right)

        return result