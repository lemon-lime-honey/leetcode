class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int small = arrays[0][0], big = arrays[0].back();
        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            result = max(result, abs(arrays[i].back() - small));
            result = max(result, abs(big - arrays[i][0]));
            small = min(small, arrays[i][0]);
            big = max(big, arrays[i].back());
        }

        return result;
    }
};