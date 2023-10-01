class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def search(r, c, route, idx):
            nonlocal result
            if len(route) == len(word):
                result = True
                return
            for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                nr, nc = r + dr, c + dc
                if (0 <= nr < n) and (0 <= nc < m):
                    if not visited[nr][nc] and board[nr][nc] == word[idx + 1]:
                        visited[nr][nc] = True
                        search(nr, nc, route + word[idx + 1], idx + 1)
                        if result: return
                        visited[nr][nc] = False

        n, m = len(board), len(board[0])
        visited = [[False for i in range(m)] for j in range(n)]
        result = False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    visited[i][j] = True
                    search(i, j, word[0], 0)
                    visited[i][j] = False

        return result
