class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        unordered_map<int, int> num_map;
        sort(nums.begin(), nums.end());
        int result = -1;

        for (int num: nums) {
            int _sqrt = sqrt(num);

            if (_sqrt * _sqrt == num && num_map.find(_sqrt) != num_map.end()) {
                num_map[num] = num_map[_sqrt] + 1;
                result = max(result, num_map[_sqrt] + 1);
            } else {
                num_map[num] = 1;
            }
        }

        return result;
    }
};