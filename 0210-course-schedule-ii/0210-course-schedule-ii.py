from collections import deque


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        deg = [0 for i in range(numCourses)]
        data = [[] for i in range(numCourses)]
        result = list()
        que = deque()

        for one, two in prerequisites:
            deg[one] += 1
            data[two].append(one)

        for i in range(numCourses):
            if deg[i] == 0:
                que.append(i)
                result.append(i)

        while que:
            now = que.popleft()

            for course in data[now]:
                deg[course] -= 1
                if deg[course] == 0:
                    que.append(course)
                    result.append(course)

        for num in deg:
            if num > 0:
                return list()

        return result