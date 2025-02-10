class Solution:
    def clearDigits(self, s: str) -> str:
        result = list()

        for c in s:
            if c.isdigit():
                if result:
                    result.pop()
                continue
            result.append(c)

        return "".join(result)