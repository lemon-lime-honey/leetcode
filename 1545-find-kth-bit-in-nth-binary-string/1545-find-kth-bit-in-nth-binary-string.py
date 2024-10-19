class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def find(n: int) -> str:
            if n == 1:
                return "0"

            before = find(n - 1)
            after = list()

            for bit in before:
                if bit == "1":
                    after.append("0")
                else:
                    after.append("1")

            return before + "1" + "".join(after[::-1])

        result = find(n)
        print(result)
        return result[k - 1]