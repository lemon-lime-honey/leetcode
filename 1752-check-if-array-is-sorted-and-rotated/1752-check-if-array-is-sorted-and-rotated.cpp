class Solution {
public:
    bool check(vector<int>& nums) {
        bool rot = false;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[(i + 1) % (nums.size())] < nums[i]) {
                if (rot) return false;
                rot = true;
            }
        }

        return true;
    }
};