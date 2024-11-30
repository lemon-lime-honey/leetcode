class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        def find(n):
            que = deque()
            que.append((0, root))

            while que:
                level, node = que.popleft()
                if node.left:
                    if node.left.val == n:
                        return level + 1, node.val
                    que.append((level + 1, node.left))
                if node.right:
                    if node.right.val == n:
                        return level + 1, node.val
                    que.append((level + 1, node.right))

            return -1, -1

        level1, parent1 = find(x)
        level2, parent2 = find(y)

        return level1 == level2 and parent1 != parent2