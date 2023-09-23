class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if len(a) > len(b):
            l = a[::-1]
            s = b[::-1]
        else:
            l = b[::-1]
            s = a[::-1]

        result = list()
        carry = False

        for i in range(len(s)):
            if carry:
                if l[i] == s[i] == '1':
                    result.append('1')
                elif l[i] == '1' or s[i] == '1':
                    result.append('0')
                else:
                    result.append('1')
                    carry = False
            else:
                if l[i] == s[i] == '1':
                    result.append('0')
                    carry = True
                elif l[i] == '1' or s[i] == '1':
                    result.append('1')
                else:
                    result.append('0')

        for i in range(len(s), len(l)):
            if carry:
                if l[i] == '1':
                    result.append('0')
                else:
                    result.append('1')
                    carry = False
            else: result.append(l[i])

        if carry: result.append('1')

        return ''.join(result[::-1])