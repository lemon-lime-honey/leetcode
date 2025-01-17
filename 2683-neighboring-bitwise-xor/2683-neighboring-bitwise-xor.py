class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        original = [0]
        chk = False

        for i in range(len(derived)):
            original.append(derived[i] ^ original[i])

        chk = original[-1] == original[0]
        original = [1]

        for i in range(len(derived)):
            original.append(derived[i] ^ original[i])

        chk |= original[-1] == original[0]

        return chk