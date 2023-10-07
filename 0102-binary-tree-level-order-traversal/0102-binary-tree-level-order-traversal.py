from collections import deque


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return

        que = deque([root])
        result = list()

        while que:
            temp = list()
            for i in range(len(que)):
                node = que.popleft()
                temp.append(node.val)
                if node.left: que.append(node.left)
                if node.right: que.append(node.right)
            result.append(temp)

        return result