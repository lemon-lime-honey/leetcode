class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        vector<int> sorted_start, sorted_end;

        for (const auto& interval: intervals) {
            sorted_start.push_back(interval[0]);
            sorted_end.push_back(interval[1]);
        }

        sort(sorted_start.begin(), sorted_start.end());
        sort(sorted_end.begin(), sorted_end.end());

        int result = 0, idx = 0;

        for (int start: sorted_start) {
            if (start > sorted_end[idx]) {
                idx++;
            } else {
                result++;
            }
        }

        return result;
    }
};