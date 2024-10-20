class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        result = 0
        que = deque([root])

        while que:
            n = len(que)

            for i in range(n):
                if i == 0:
                    result = que[0].val
                if que[0].left:
                    que.append(que[0].left)
                if que[0].right:
                    que.append(que[0].right)
                que.popleft()

        return result