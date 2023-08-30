from collections import defaultdict


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        indices = defaultdict(list)

        for index, number in enumerate(nums):
            indices[number].append(index)

        for i in indices.values():
            i.sort()
            if len(i) > 1:
                for j in range(len(i) - 1):
                    if i[j + 1] - i[j] <= k: return True

        return False