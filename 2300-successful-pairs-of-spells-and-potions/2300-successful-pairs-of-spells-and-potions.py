class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        result = list()
        potions.sort()
        n = len(potions)

        for spell in spells:
            lo, hi = 0, n - 1

            while lo <= hi:
                mid = (lo + hi) // 2
                chk = potions[mid] * spell - success
                if chk >= 0:
                    hi = mid - 1
                else:
                    lo = mid + 1

            result.append(n - lo)

        return result