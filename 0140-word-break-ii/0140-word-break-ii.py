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


    def find(self, idx, string):
        result = list()
        node = self.root

        for i in range(idx, len(string)):
            if string[i] not in node.children:
                return result
            if hasattr(node.children[string[i]], 'last'):
                result.append(i + 1)
            node = node.children[string[i]]

        return result


class TrieNode:
    def __init__(self):
        self.children = dict()


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        def run(idx, route):
            targets = trie.find(idx, s)
            for target in targets:
                route.append(s[idx: target])
                if target == len(s):
                    result.append(' '.join(route))
                else:
                    run(target, route)
                route.pop()


        trie = Trie()
        result = list()

        for word in wordDict:
            trie.insert(word)

        run(0, list())

        return result