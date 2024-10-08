class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int result = 0;

        for (int i = 1; i < nums.size() + 1; i++) {
            result ^= i;
        }

        for (int i = 0; i < nums.size(); i++) {
            result ^= nums[i];
        }

        return result;
    }
};