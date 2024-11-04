class Solution:
    def compressedString(self, word: str) -> str:
        result = list()
        cnt = 1

        for i in range(1, len(word)):
            if word[i] == word[i - 1]:
                if cnt == 9:
                    result.append(str(cnt))
                    result.append(word[i - 1])
                    cnt = 1
                else:
                    cnt += 1
            else:
                result.append(str(cnt))
                result.append(word[i - 1])
                cnt = 1

        result.append(str(cnt))
        result.append(word[-1])

        return ''.join(result)