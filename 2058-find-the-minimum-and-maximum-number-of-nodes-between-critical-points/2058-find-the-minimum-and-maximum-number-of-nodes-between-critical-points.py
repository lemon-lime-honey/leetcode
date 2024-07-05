class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        points = list()
        before = -1
        idx = 0

        while head and head.next:
            if (before != -1 and (
                (head.val < before and head.val < head.next.val) or
                (head.val > before and head.val > head.next.val))):
                points.append(idx)

            idx += 1
            before = head.val
            head = head.next

        if len(points) < 2: return [-1, -1]
        result = [int(1e12), 0]

        for i in range(1, len(points)):
            result[0] = min(result[0], points[i] - points[i - 1])
            result[1] = max(result[1], points[i] - points[0])

        return result