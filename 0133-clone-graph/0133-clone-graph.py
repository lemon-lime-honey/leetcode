from collections import deque
from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return None

        nodeDict = dict()
        clone = Node(val=node.val)
        nodeDict[clone.val] = clone
        que = deque([node])

        while que:
            chk = que.popleft()

            for nb in chk.neighbors:
                if nb.val not in nodeDict:
                    new = Node(val=nb.val)
                    nodeDict[nb.val] = new
                    nodeDict[chk.val].neighbors.append(new)
                    que.append(nb)
                else:
                    target = nodeDict[nb.val]
                    if target not in nodeDict[chk.val].neighbors:
                        nodeDict[chk.val].neighbors.append(target)

        return nodeDict[node.val]