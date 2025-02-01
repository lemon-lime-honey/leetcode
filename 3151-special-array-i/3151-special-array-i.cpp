class Solution {
public:
    bool isArraySpecial(vector<int>& nums) {
        bool result = true;
        bool parity;

        if (nums[0] % 2 == 1) parity = true;
        else parity = false;

        for (int i = 1; i < nums.size(); i++) {
            if (parity) {
                if (nums[i] % 2 == 0) parity = false;
                else result = false;
            } else {
                if (nums[i] % 2 == 0) result = false;
                else parity = true;
            }

            if (!result) break;
        }

        return result;
    }
};