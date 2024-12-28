class ProductOfNumbers:
    def __init__(self):
        self.mul = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.mul = [1]
        else:
            self.mul.append(self.mul[-1] * num)

    def getProduct(self, k: int) -> int:
        if len(self.mul) <= k:
            return 0
        return self.mul[-1] // self.mul[- k - 1]
