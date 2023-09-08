class Node:
    def __init__(self):
        self.children: Dict[str, Node] = {}
        self.value: Optional[Any] = None


class Trie:
    def __init__(self):
        self.root = Node()


    def insert(self, word: str) -> None:
        chk = self.root
        for i in range(len(word)):
            if word[i] in chk.children:
                chk = chk.children[word[i]]
            else:
                new = Node()
                new.value = word[i]
                chk.children[word[i]] = new
                chk = chk.children[word[i]]
            if i == len(word) - 1:
                chk.lastword = True


    def search(self, word: str) -> bool:
        chk = self.root
        for i in range(len(word)):
            if word[i] in chk.children:
                chk = chk.children[word[i]]
            else: return False
        if hasattr(chk, 'lastword'): return True
        return False


    def startsWith(self, prefix: str) -> bool:
        chk = self.root
        for i in range(len(prefix)):
            if prefix[i] in chk.children:
                chk = chk.children[prefix[i]]
            else: return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)