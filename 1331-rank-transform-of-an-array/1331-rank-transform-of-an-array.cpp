class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int> result(arr.size());
        unordered_map<int, int> rank_map;
        vector<int> sorted_without_duplicate = arr;
        sort(sorted_without_duplicate.begin(), sorted_without_duplicate.end());
        sorted_without_duplicate.erase(unique(sorted_without_duplicate.begin(), sorted_without_duplicate.end()), sorted_without_duplicate.end());

        for (int i = 0; i < sorted_without_duplicate.size(); i++) {
            if (i > 0 && sorted_without_duplicate[i] == sorted_without_duplicate[i - 1]) {
                break;
            }
            rank_map[sorted_without_duplicate[i]] = i + 1;
        }

        for (int i = 0; i < arr.size(); i++) {
            result[i] = rank_map[arr[i]];
        }

        return result;
    }
};