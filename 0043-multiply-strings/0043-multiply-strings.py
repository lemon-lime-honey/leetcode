class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0": return "0"

        result = [0 for i in range(len(num1) + len(num2))]

        for i in range(len(num1) - 1, -1, -1):
            for j in range(len(num2) - 1, -1, -1):
                result[i + j + 1] += int(num1[i]) * int(num2[j])
                result[i + j] += result[i + j + 1] // 10
                result[i + j + 1] %= 10

        ref = 0

        for n in result:
            if n != 0:
                break
            ref += 1
  
        return ''.join(map(str, result[ref:]))