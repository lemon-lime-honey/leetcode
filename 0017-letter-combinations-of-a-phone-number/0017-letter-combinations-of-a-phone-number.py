class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def search(idx, res):
            if len(res) == len(digits):
                result.append(''.join(res))
                return

            for i in range(idx + 1, len(digits)):
                for letter in letterDict[digits[i]]:
                    res.append(letter)
                    search(i, res)
                    res.pop()
        

        if not digits: return list()

        letterDict = {'2': 'abc', '3': 'def',
                      '4': 'ghi', '5': 'jkl',
                      '6': 'mno', '7': 'pqrs',
                      '8': 'tuv', '9': 'wxyz'}
        
        result = list()
        res = list()
        search(-1, res)

        return result