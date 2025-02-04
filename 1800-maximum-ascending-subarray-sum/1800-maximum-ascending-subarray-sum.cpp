class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int result = 0, now = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i - 1] < nums[i]) {
                now += nums[i];
            } else {
                result = max(result, now);
                now = nums[i];
            }
        }

        result = max(result, now);

        return result;
    }
};