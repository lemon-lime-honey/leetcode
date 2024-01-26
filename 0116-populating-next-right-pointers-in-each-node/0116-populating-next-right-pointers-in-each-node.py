from collections import deque


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root or not root.left:
            return root

        que = deque()
        que.append(root.right)
        que.append(root.left)

        while que:
            n = len(que)
            before = None
            for i in range(n):
                now = que.popleft()
                if i:
                    now.next = before
                if now.right and now.left:
                    que.append(now.right)
                    que.append(now.left)
                before = now

        return root