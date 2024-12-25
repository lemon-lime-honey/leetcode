class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        que = deque()
        result = list()

        if root:
            que.append(root)

        while que:
            n = len(que)
            target = que[0].val

            for i in range(n):
                node = que.popleft()
                target = max(target, node.val)
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

            result.append(target)

        return result