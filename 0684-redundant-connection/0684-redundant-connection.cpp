class Solution {
private:
    vector<int> parent;

    int find(int p) {
        if (parent[p] == p) return p;
        parent[p] = find(parent[p]);
        return parent[p];
    }

    bool _union(int p, int q) {
        p = find(p);
        q = find(q);

        if (p == q) return true;
        if (p < q) parent[q] = p;
        else parent[p] = q;

        return false;
    }

public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> result;

        for (int i = 0; i < edges.size() + 1; i++) {
            parent.push_back(i);
        }

        for (int i = 0; i < edges.size(); i++) {
            if (_union(edges[i][0], edges[i][1])) result.push_back(i);
        }

        return edges[result[result.size() - 1]];
    }
};