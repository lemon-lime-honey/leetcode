from collections import deque


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return list()

        result = list()
        que = deque([root])

        while que:
            n = len(que)
            temp = list()

            for i in range(n):
                now = que.popleft()
                temp.append(now.val)

                if now.left:
                    que.append(now.left)
                if now.right:
                    que.append(now.right)

            result.append(temp)

        return result[::-1]