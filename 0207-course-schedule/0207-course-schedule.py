from collections import defaultdict, deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        deg = [0 for i in range(numCourses)]
        pre = defaultdict(list)

        for one, two in prerequisites:
            pre[two].append(one)
            deg[one] += 1

        que = deque()

        for i in range(numCourses):
            if deg[i] == 0:
                que.append(i)

        while que:
            now = que.popleft()
            for course in pre[now]:
                deg[course] -= 1
                if deg[course] == 0:
                    que.append(course)

        print(*deg)

        for i in range(numCourses):
            if deg[i] != 0:
                return False

        return True