class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answer = [0 for i in range(n)]
        stack = list()

        for i in range(n):
            if stack and stack[-1][0] < temperatures[i]:
                while stack and stack[-1][0] < temperatures[i]:
                    t, d = stack.pop()
                    answer[d] = i - d
            stack.append((temperatures[i], i))

        return answer