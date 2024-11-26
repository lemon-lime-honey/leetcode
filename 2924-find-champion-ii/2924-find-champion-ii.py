class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        result = [True for i in range(n)]

        for winner, loser in edges:
            result[loser] = False

        res = -1
        cnt = 0

        for i in range(n):
            if result[i]:
                res = i
                cnt += 1

        if cnt == 1:
            return res

        return -1