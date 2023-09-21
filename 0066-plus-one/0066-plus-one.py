class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits) - 1, -1, -1):
            if i == len(digits) - 1:
                digits[i] += 1
            if digits[i] > 9 and i > 0:
                c = digits[i] // 10
                digits[i] %= 10
                digits[i - 1] += c
        if digits[0] > 9:
            c = digits[0] // 10
            digits[0] %= 10
            return [c] + digits
        return digits