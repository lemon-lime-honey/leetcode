class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if not nums: return list()

        result = list()
        start = nums[0]

        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1] + 1: continue
            else:
                if start == nums[i - 1]: result.append(str(start))
                else: result.append(f'{start}->{nums[i - 1]}')
                start = nums[i]

        if start == nums[-1]: result.append(str(start))
        else: result.append(f'{start}->{nums[-1]}')

        return result