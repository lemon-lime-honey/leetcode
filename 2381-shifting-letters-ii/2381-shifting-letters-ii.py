class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        prefix = [0 for i in range(len(s) + 1)]
        letters = list()

        for start, end, direction in shifts:
            prefix[start] += 2 * direction - 1
            prefix[end + 1] -= 2 * direction - 1

        shift = 0

        for i in range(len(s)):
            shift += prefix[i]
            target = (shift % 26 + 26) % 26
            letters.append(chr((ord(s[i]) - ord("a") + target) % 26 + ord("a")))

        return "".join(letters)