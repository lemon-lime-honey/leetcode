class TrieNode:
    def __init__(self, val=None):
        self.val = val
        self.children = dict()
        self.last = False


class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.found = dict()


    def insert(self, word):
        node = self.root
        for letter in word:
            if letter not in node.children:
                new = TrieNode(letter)
                node.children[letter] = new
            node = node.children[letter]
        node.last = True


    def search(self, string):
        node = self.root

        for i in range(len(string)):
            if string[i] not in node.children: return False
            if node.children[string[i]].last:
                left = string[i+1:]
                if left not in self.found:
                    self.found[left] = self.search(left)
                if self.found[left]: return True
            node = node.children[string[i]]
        return node.last


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        trie = Trie()

        for word in wordDict:
            trie.insert(word)

        return trie.search(s)