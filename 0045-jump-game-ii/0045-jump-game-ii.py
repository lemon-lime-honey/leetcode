class Solution:
    def jump(self, nums: List[int]) -> int:
        reach, cnt, last = 0, 0, 0

        for i in range(len(nums) - 1):
            reach = max(reach, i + nums[i])

            if i == last:
                last = reach
                cnt += 1

        return cnt