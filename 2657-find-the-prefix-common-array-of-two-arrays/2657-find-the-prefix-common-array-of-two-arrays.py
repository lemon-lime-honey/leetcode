class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        result = [0 for i in range(len(A))]
        common, mask = 0, 0

        for i in range(len(A)):
            a, b = 1 << (A[i] - 1), 1 << (B[i] - 1)

            if mask & a:
                common += 1
            else:
                mask |= a

            if mask & b:
                common += 1
            else:
                mask |= b

            result[i] = common

        return result