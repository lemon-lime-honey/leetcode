class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = Counter(nums1), Counter(nums2)
        result = list()

        for num in n1.keys():
            if num in n2:
                for i in range(min(n1[num], n2[num])):
                    result.append(num)

        return result