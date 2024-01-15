from collections import deque


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None: return root

        que = deque()
        que.append(root)

        while que:
            n = len(que)
            before = None
            for i in range(n):
                now = que.popleft()
                if before: now.next = before
                before = now
                if now.right: que.append(now.right)
                if now.left: que.append(now.left)

        return root