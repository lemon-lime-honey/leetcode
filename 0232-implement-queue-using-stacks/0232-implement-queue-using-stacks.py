class MyQueue:
    def __init__(self):
        self._in = list()
        self._out = list()

    def push(self, x: int) -> None:
        self._in.append(x)

    def pop(self) -> int:
        self.peek()
        return self._out.pop()

    def peek(self) -> int:
        if not self._out:
            while self._in:
                self._out.append(self._in.pop())
        return self._out[-1]

    def empty(self) -> bool:
        return not self._in and not self._out
