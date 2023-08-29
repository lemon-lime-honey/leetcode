class MinStack:
    def __init__(self):
        self.stack = list()
        self.minimum = list()

    def push(self, val: int) -> None:
        if not len(self.minimum): self.minimum.append(val)
        else: self.minimum.append(min(self.minimum[-1], val))
        self.stack.append(val)

    def pop(self) -> None:
        self.minimum.pop()
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimum[-1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()