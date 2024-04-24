class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        que = deque([root])
        result = [1, root.val]
        level = 0

        while que:
            n = len(que)
            level += 1
            temp = 0
            for i in range(n):
                now = que.popleft()
                temp += now.val
                if now.left: que.append(now.left)
                if now.right: que.append(now.right)
            if result[1] < temp:
                result[1] = temp
                result[0] = level

        return result[0]