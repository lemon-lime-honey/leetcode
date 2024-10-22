class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        result = list()
        que = deque([root])

        while que:
            n = len(que)
            level_sum = 0

            for i in range(n):
                node = que.popleft()
                level_sum += node.val

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

            heapq.heappush(result, level_sum)

            if len(result) > k:
                heapq.heappop(result)

        if len(result) < k:
            return -1

        return result[0]