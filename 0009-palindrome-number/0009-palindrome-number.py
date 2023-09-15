from collections import deque


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0: return False
        n = deque()

        while x:
            n.append(x % 10)
            x //= 10

        while len(n) > 1:
            if n[0] == n[-1]:
                n.pop()
                n.popleft()
            else:
                return False

        return True