class Solution {
private:
    vector<string> result;

    void generate(string route, int lo, int hi, int n) {
        if (route.size() == 2 * n) {
            result.push_back(route);
            return;
        }
        if (lo < n) generate(route + "(", lo + 1, hi, n);
        if (hi < lo) generate(route + ")", lo, hi + 1, n);
    }

public:
    vector<string> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return result;
    }
};