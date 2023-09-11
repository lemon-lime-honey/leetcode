class TrieNode:
    def __init__(self):
        self.children = dict()
        self.value = None


class Trie:
    def __init__(self):
        self.root = TrieNode()


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        def search(r, c, node, route):
            nonlocal n1, n2, result, visited

            if hasattr(node, 'last'):
                result.add(route)
                if not node.children: return True
            
            for nr, nc in ((r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)):
                if (0 <= nr < n1) and (0 <= nc < n2):
                    if not visited[nr][nc] and board[nr][nc] in node.children:
                        visited[nr][nc] = True
                        chk = search(nr, nc, node.children[board[nr][nc]], route + board[nr][nc])
                        if chk: node.children.pop(board[nr][nc])
                        visited[nr][nc] = False

            return False if node.children else True


        trie = Trie()
        n1, n2 = len(board), len(board[0])
        result = set()

        for word in words:
            node = trie.root
            for i in range(len(word)):
                if word[i] not in node.children:
                    new = TrieNode()
                    new.value = word[i]
                    node.children[word[i]] = new
                node = node.children[word[i]]
            node.last = True

        for i in range(n1):
            for j in range(n2):
                if board[i][j] in trie.root.children:
                    visited = [[False for k in range(n2)] for l in range(n1)]
                    visited[i][j] = True
                    search(i, j, trie.root.children[board[i][j]], board[i][j])

        return list(result)