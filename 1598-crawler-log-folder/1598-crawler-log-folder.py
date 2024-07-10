class Solution:
    def minOperations(self, logs: List[str]) -> int:
        result = 0

        for log in logs:
            if log == "../": result = max(result - 1, 0)
            elif log == "./": continue
            else: result += 1

        return result