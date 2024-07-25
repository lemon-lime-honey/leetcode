class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        def find(p):
            if parent[p] == p: return p
            parent[p] = find(parent[p])
            return parent[p]


        def union(p, q):
            p, q = find(p), find(q)
            if p == q: return True
            if p < q: parent[q] = p
            else: parent[p] = q
            return False

        result = list()
        parent = [i for i in range(len(edges) + 1)]

        for i in range(len(edges)):
            if union(edges[i][0], edges[i][1]):
                result.append(i)

        return edges[result[-1]]