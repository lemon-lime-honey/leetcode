class Solution {
    private int[] parent;

    private int find(int p) {
        if (parent[p] == p) return p;
        parent[p] = find(parent[p]);
        return parent[p];
    }

    private boolean union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p == q) return true;
        if (p < q) parent[q] = p;
        else parent[p] = q;
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        List<Integer> result = new ArrayList<>();
        parent = new int[edges.length + 1];

        for (int i = 0; i < edges.length + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1])) result.add(i);
        }

        return edges[result.get(result.size() - 1)];
    }
}