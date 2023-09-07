from collections import deque
from statistics import mean


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        que = deque([(root, 0)])
        total = [[root.val]]
        root.visited = True

        while que:
            now, depth = que.popleft()

            if now.left and not hasattr(now.left, 'visited'):
                now.left.visited = True
                que.append((now.left, depth + 1))

                if len(total) == depth + 1:
                    total.append([now.left.val])
                else:
                    total[depth + 1].append(now.left.val)

            if now.right and not hasattr(now.right, 'visited'):
                now.right.visited = True
                que.append((now.right, depth + 1))

                if len(total) == depth + 1:
                    total.append([now.right.val])
                else:
                    total[depth + 1].append(now.right.val)


        result = [0.0 for i in range(len(total))]

        for i in range(len(total)):
            result[i] = mean(total[i])

        return result