class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def permutation():
            if len(route) == len(nums):
                result.append(list(route))
                return

            for i in range(len(nums)):
                if not visited[i]:
                    visited[i] = True
                    route.append(nums[i])
                    permutation()
                    visited[i] = False
                    route.pop()


        visited = [False for i in range(len(nums))]
        result = list()
        route = list()
        permutation()

        return result