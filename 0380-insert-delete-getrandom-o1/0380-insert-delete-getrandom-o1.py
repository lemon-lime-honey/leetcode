from random import choice


class RandomizedSet:
    def __init__(self):
        self.d = dict()
        self.l = list()


    def insert(self, val: int) -> bool:
        if val in self.d: return False
        self.d[val] = len(self.l)
        self.l.append(val)
        return True


    def remove(self, val: int) -> bool:
        if val not in self.d: return False
        index, last = self.d[val], self.l[-1]
        self.d[last] = index
        self.l[index] = last
        self.d.pop(val)
        self.l.pop()
        return True


    def getRandom(self) -> int:
        return choice(self.l)