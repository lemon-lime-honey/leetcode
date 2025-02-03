class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        if (nums.size() == 1) return 1;

        int n = nums.size();
        int asc = 1, desc = 1, result = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                asc++;
                desc = 1;
            } else if (nums[i] < nums[i - 1]) {
                desc++;
                asc = 1;
            } else {
                asc = desc = 1;
            }
            result = max({result, asc, desc});
        }

        return result;
    }
};