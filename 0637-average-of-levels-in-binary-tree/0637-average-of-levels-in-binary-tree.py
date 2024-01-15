from collections import deque


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        que = deque([root])
        result = list()

        while que:
            n = len(que)
            total = 0.0

            for i in range(n):
                now = que.popleft()
                total += now.val
                if now.left:
                    que.append(now.left)
                if now.right:
                    que.append(now.right)

            result.append(total / n)

        return result