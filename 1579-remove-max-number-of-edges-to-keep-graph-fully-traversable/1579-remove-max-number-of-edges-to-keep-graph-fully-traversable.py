class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        def find(p):
            if parent[p] != p:
                parent[p] = find(parent[p])
            return parent[p]

        def union(p, q):
            p, q = find(p), find(q)
            if p == q: return True
            if p < q: parent[q] = p
            else: parent[p] = q
            return False


        three, two, one = list(), list(), list()
        parent = [i for i in range(n + 1)]
        result = [0, 0, 0]

        for t, u, v in edges:
            if t == 1:
                one.append((u, v))
            elif t == 2:
                two.append((u, v))
            else:
                three.append((u, v))

        for u, v in three:
            if union(u, v):
                result[2] += 1
            else:
                result[0] += 1
                result[1] += 1

        before = copy.deepcopy(parent)

        for u, v in one:
            if union(u, v):
                result[2] += 1
            else:
                result[0] += 1

        parent = before

        for u, v in two:
            if union(u, v):
                result[2] += 1
            else:
                result[1] += 1

        return result[2] if result[0] == n - 1 and result[1] == n - 1 else -1