class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        def get_val(n):
            target = str(n)
            res = 0
            for i in range(len(target)):
                res = res * 10 + mapping[int(target[i])]
            return res


        result = list()

        for i in range(len(nums)):
            result.append((nums[i], get_val(nums[i]), i))

        return [x[0] for x in sorted(result, key=lambda x: (x[1], x[2]))]
