class Solution:
    def minSwaps(self, s: str) -> int:
        result = 0

        for letter in s:
            if letter == '[':
                result += 1
            elif result > 0:
                result -= 1

        return (result + 1) // 2