class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        result = list()
        for i in range(1, n + 1):
            if not i % 3:
                if not i % 5:
                    result.append('FizzBuzz')
                else:
                    result.append('Fizz')
            elif not i % 5:
                result.append('Buzz')
            else:
                result.append(str(i))
        return result