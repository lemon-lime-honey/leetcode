class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> cnt;
        set<int> seen;

        for (int num: arr) {
            cnt[num]++;
        }

        for (auto elem: cnt) {
            if (seen.find(elem.second) != seen.end()) {
                return false;
            }
            seen.insert(elem.second);
        }

        return true;
    }
};