class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        cnt = Counter(arr)
        seen = set()

        for num in cnt.values():
            if num in seen: return False
            seen.add(num)

        return True