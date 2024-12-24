class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        def cnt(node):
            if node is None:
                return

            table[node.val] += 1
            cnt(node.left)
            cnt(node.right)

        table = defaultdict(int)
        cnt(root)

        result = sorted(table.items(), key=lambda x: (-x[1], x[0]))
        answer = list()

        for i in range(len(result)):
            if i == 0 or result[i][1] == result[i - 1][1]:
                answer.append(result[i][0])
                continue
            break

        return answer
