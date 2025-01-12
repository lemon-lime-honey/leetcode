class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2: return False
        
        maximum, minimum = 0, 0

        for i in range(len(s)):
            if locked[i] == "1":
                if s[i] == "(":
                    minimum += 1
                    maximum += 1
                else:
                    minimum -= 1
                    maximum -= 1
            else:
                maximum += 1
                minimum -= 1
            if maximum < 0: return False
            minimum = max(minimum, 0)

        return minimum == 0