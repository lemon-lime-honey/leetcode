class Trie:
    def __init__(self):
        self.root = TrieNode()


    def insert(self, word):
        node = self.root

        for letter in word:
            target = ord(letter) - ord('a')
            if node.children[target] is None:
                node.children[target] = TrieNode()
            node = node.children[target]
            if len(node.words) < 3:
                node.words.append(word)


    def search(self, word):
        node = self.root

        for letter in word:
            target = ord(letter) - ord('a')
            if node.children[target] is None:
                return list()
            node = node.children[target]

        return node.words


class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.words = list()


class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products.sort()
        trie = Trie()
        result = list()

        for product in products:
            trie.insert(product)

        for i in range(len(searchWord)):
            result.append(trie.search(searchWord[:i+1]))

        return result