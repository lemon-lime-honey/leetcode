class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        result = list()

        for num in nums:
            result.extend(list(map(int, list(str(num)))))

        return result