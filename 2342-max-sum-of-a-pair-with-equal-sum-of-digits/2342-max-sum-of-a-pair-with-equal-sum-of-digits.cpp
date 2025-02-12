class Solution {
private:
    int get_sum(int n) {
        int result = 0;

        while (n != 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

public:
    int maximumSum(vector<int>& nums) {
        unordered_map<int, int> data;
        int result = -1;

        for (int num: nums) {
            int sum = get_sum(num);

            if (data.find(sum) == data.end()) {
                data[sum] = num;
            } else {
                result = max(result, data[sum] + num);
                data[sum] = max(data[sum], num);
            }
        }

        return result;
    }
};