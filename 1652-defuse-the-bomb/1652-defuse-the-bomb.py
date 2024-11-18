class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        if k == 0: return [0 for i in range(len(code))]

        result = code + code

        if k > 0:
            return [sum(result[i + 1:i + k + 1]) for i in range(len(code))]
        k *= -1
        return [sum(result[i - k:i]) for i in range(len(code), 2 * len(code))]