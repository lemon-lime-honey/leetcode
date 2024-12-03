class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        result = list()
        idx = 0

        for i in range(len(s)):
            if idx < len(spaces) and i == spaces[idx]:
                result.append(" ")
                idx += 1
            result.append(s[i])

        return "".join(result)