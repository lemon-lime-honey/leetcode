class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        result = list()
        graph = dict()
        cnt = 0

        for i in range(len(values)):
            if equations[i][0] not in graph:
                graph[equations[i][0]] = [(equations[i][1], values[i])]
            else:
                graph[equations[i][0]].append((equations[i][1], values[i]))
            if equations[i][1] not in graph:
                graph[equations[i][1]] = [(equations[i][0], 1 / values[i])]
            else:
                graph[equations[i][1]].append((equations[i][0], 1 / values[i]))

        for query in queries:
            if query[0] not in graph or query[1] not in graph:
                result.append(-1.0)
                continue

            if query[0] == query[1]:
                result.append(1.0)
                continue

            que = [(1.0, query[0])]
            flag = False
            chk = set()

            while que:
                val, now = heapq.heappop(que)
                for next_letter, next_val in graph[now]:
                    if next_letter in chk:
                        continue
                    if next_letter == query[1]:
                        result.append(next_val * val)
                        flag = True
                        break
                    chk.add(next_letter)
                    heapq.heappush(que, (next_val * val, next_letter))

                if flag: break

            if not flag:
                result.append(-1.0)

        return result