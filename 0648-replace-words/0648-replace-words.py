class TrieNode:
    def __init__(self):
        self.children = dict()


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for letter in word:
            if letter not in node.children:
                node.children[letter] = TrieNode()
            node = node.children[letter]
        node.last = True

    def findRoot(self, word):
        node = self.root
        idx = 0
        for letter in word:
            if hasattr(node, 'last'):
                break
            if letter not in node.children:
                idx = len(word)
                break
            node = node.children[letter]
            idx += 1
        return word[:idx]


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        result = list()

        for word in dictionary:
            trie.insert(word)

        for word in sentence.split():
            result.append(trie.findRoot(word))

        return ' '.join(result)