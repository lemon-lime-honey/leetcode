class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        result = list()
        flag = False

        for i in range(0, len(s), k):
            if flag:
                result.append(s[i:i + k])
                flag = False
            else:
                result.append(s[i:i + k][::-1])
                flag = True

        return ''.join(result)