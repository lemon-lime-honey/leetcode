class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def permute(route):
            if len(route) == len(nums):
                result.append(list(route))
                return
            
            for i in range(len(nums)):
                if chk[i] or (i > 0 and nums[i] == nums[i - 1] and not chk[i - 1]):
                    continue
                chk[i] = True
                route.append(nums[i])
                permute(route)
                route.pop()
                chk[i] = False


        chk = [False for i in range(len(nums))]
        result = list()
        nums.sort()

        permute(list())
        return result