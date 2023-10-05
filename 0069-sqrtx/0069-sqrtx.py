class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2: return x

        result = 2
        while result * result <= x:
            result += 1
        
        return result - 1