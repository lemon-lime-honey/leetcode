class Solution:
    def romanToInt(self, s: str) -> int:
        letterDict = {'I': 1, 'V': 5, 'X': 10, 'L': 50,
                      'C': 100, 'D': 500, 'M': 1000}
        length = len(s)
        result = 0
        i = 0

        while i < length:
            if i == length - 1:
                result += letterDict[s[i]]
                i += 1
            else:
                if letterDict[s[i]] < letterDict[s[i + 1]]:
                    result += letterDict[s[i + 1]] - letterDict[s[i]]
                    i += 2
                else:
                    result += letterDict[s[i]]
                    i += 1

        return result