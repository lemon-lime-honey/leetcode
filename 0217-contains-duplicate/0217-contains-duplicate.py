class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        cnt = Counter(nums).most_common()
        return cnt[0][1] > 1