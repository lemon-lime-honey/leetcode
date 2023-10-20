class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = list()

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]: continue
            lo, hi = i + 1, len(nums) - 1
            while lo < hi:
                if (nums[lo] + nums[hi]) == -nums[i]:
                    result.append([nums[i], nums[lo], nums[hi]])
                    lo += 1

                    while nums[lo] == nums[lo - 1] and lo < hi:
                        lo += 1

                elif (nums[lo] + nums[hi]) < -nums[i]: lo += 1
                else: hi -= 1
        
        return result