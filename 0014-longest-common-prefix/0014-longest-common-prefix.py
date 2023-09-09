class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = list()

        for i in range(min(map(len, strs))):
            letter = strs[0][i]
            for j in range(1, len(strs)):
                if strs[j][i] != letter:
                    return ''.join(result)
                    break
            else:
                result.append(letter)

        return ''.join(result)