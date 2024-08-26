class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        def traverse(node):
            if not node: return

            for child in node.children:
                traverse(child)

            result.append(node.val)

        result = list()
        traverse(root)
        return result