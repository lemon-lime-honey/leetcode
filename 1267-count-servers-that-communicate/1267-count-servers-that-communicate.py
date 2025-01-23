class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]:
                    flag = False
                    for k in range(len(grid[0])):
                        if grid[i][k] and k != j:
                            flag = True
                            break
                    if not flag:
                        for k in range(len(grid)):
                            if grid[k][j] and k != i:
                                flag = True
                                break
                    if flag: result += 1

        return result
