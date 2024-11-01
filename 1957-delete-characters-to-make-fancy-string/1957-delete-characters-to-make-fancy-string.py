class Solution:
    def makeFancyString(self, s: str) -> str:
        result = list()
        cnt = 0

        for index, letter in enumerate(s):
            if index == 0 or letter != s[index - 1]:
                result.append(letter)
                cnt = 1
            else:
                if cnt == 2:
                    continue
                else:
                    cnt += 1
                    result.append(letter)

        return ''.join(result)
