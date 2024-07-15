class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        nodeDict = dict()
        parent = dict()

        for p, c, d in descriptions:
            if p not in nodeDict:
                nodeDict[p] = TreeNode(p)
            if c not in nodeDict:
                nodeDict[c] = TreeNode(c)
            if d: nodeDict[p].left = nodeDict[c]
            else: nodeDict[p].right = nodeDict[c]
            if p not in parent: parent[p] = -1
            parent[c] = p

        for key, value in parent.items():
            if value == -1:
                return nodeDict[key]

        return