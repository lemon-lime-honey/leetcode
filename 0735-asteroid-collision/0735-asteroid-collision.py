class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        result = list()

        for asteroid in asteroids:
            if (not result or
                result[-1] * asteroid > 0 or
                result[-1] < 0 and asteroid > 0):
                result.append(asteroid)
            else:
                flag = True
                while result and result[-1] * asteroid < 0:
                    if abs(result[-1]) < abs(asteroid):
                        result.pop()
                    elif abs(result[-1]) == abs(asteroid):
                        result.pop()
                        flag = False
                        break
                    else:
                        flag = False
                        break
                if flag:
                    result.append(asteroid)

        return result