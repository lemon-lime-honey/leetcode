class CustomStack:
    def __init__(self, maxSize: int):
        self.stack = [-1 for i in range(maxSize)]
        self.idx = 0

    def push(self, x: int) -> None:
        if self.idx < len(self.stack):
            self.stack[self.idx] = x
            self.idx += 1

    def pop(self) -> int:
        if self.stack[0] == -1: return -1
        result = self.stack[self.idx - 1]
        self.stack[self.idx - 1] = -1
        self.idx -= 1
        return result

    def increment(self, k: int, val: int) -> None:
        print(self.stack)
        for i in range(min(k, self.idx)):
            self.stack[i] += val
