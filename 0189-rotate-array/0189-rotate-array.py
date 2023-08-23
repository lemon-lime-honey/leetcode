from collections import deque


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        temp = deque(nums)
        temp.rotate(k)
        nums[:] = list(temp)