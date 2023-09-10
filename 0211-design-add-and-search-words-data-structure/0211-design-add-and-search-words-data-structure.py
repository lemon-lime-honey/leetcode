class Node:
    def __init__(self):
        self.children = dict()
        self.value = None


class WordDictionary:
    def __init__(self):
        self.root = Node()
        

    def addWord(self, word: str) -> None:
        chk = self.root

        for i in range(len(word)):
            if word[i] not in chk.children:
                new = Node()
                new.value = word[i]
                chk.children[word[i]] = new
            chk = chk.children[word[i]]

        chk.last = True


    def search(self, word: str) -> bool:
        def subSearch(index, node):
            nonlocal word

            for i in range(index, len(word)):
                if word[i] == '.':
                    if i == len(word) - 1:
                        for child in node.children.values():
                            if hasattr(child, 'last'): return True
                        return False
                    for child in node.children.values():
                        chk = subSearch(i + 1, child)
                        if chk: return True
                    else:
                        return False
                elif word[i] in node.children:
                    node = node.children[word[i]]
                    if i == len(word) - 1:
                        return hasattr(node, 'last')
                else: return False


        return subSearch(0, self.root)