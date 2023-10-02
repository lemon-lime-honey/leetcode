"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return

        nodeDict = dict()
        result = Node(x=head.val)
        node = result

        nodeDict[head] = result

        while head:
            if head.next and head.next not in nodeDict:
                new = Node(x=head.next.val)
                nodeDict[head.next] = new
                node.next = new
            elif head.next and head.next in nodeDict:
                node.next = nodeDict[head.next]

            if head.random and head.random not in nodeDict:
                new = Node(x=head.random.val)
                nodeDict[head.random] = new
                node.random = new
            elif head.random and head.random in nodeDict:
                node.random = nodeDict[head.random]

            head = head.next
            node = node.next

        return result