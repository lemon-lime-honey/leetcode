from collections import deque


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        letters, chk = deque(), set()
        result = 0

        for i in range(len(s)):
            if s[i] not in chk:
                letters.append(s[i])
                chk.add(s[i])
            else:
                while letters[0] != s[i]:
                    chk.remove(letters.popleft())
                letters.popleft()
                letters.append(s[i])
            result = max(result, len(letters))

        return result