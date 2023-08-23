from collections import Counter


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        num_cnt = Counter(nums)
        return num_cnt.most_common(1)[0][0]