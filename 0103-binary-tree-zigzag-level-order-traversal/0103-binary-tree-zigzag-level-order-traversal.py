from collections import deque


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = list()
        if root is None: return result

        direction = True
        que = deque([root])

        while que:
            length = len(que)
            temp = list()

            for i in range(length):
                node = que.popleft()
                temp.append(node.val)

                if node.left: que.append(node.left)
                if node.right: que.append(node.right)

            if direction:
                result.append(temp)
                direction = False
            else:
                result.append(temp[::-1])
                direction = True

        return result