class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        x, y, d = 0, 0, 0
        result = 0

        obs = set(map(tuple, obstacles))

        for command in commands:
            if command > 0:
                for i in range(command):
                    nx, ny = x + direction[d][0], y + direction[d][1]
                    if (nx, ny) in obs: break
                    x, y = nx, ny
                    result = max(result, x * x + y * y)
            elif command == -1:
                d = (d + 1) % 4
            else:
                d = (d - 1) % 4

        return result