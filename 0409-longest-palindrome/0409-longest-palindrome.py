class Solution:
    def longestPalindrome(self, s: str) -> int:
        letters = [0 for i in range(52)]
        for letter in s:
            if letter.isupper():
                letters[ord(letter) - ord('A')] += 1
            else:
                letters[ord(letter) - ord('a') + 26] += 1
        odd = False
        result = 0
        for num in letters:
            if num % 2:
                if not odd:
                    odd = True
                    result += num
                else:
                    result += num - 1
            else:
                result += num
        return result