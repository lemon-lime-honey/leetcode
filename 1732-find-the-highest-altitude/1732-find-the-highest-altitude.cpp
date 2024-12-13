class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int result = 0, num = 0;

        for (int n: gain) {
            num += n;
            result = max(result, num);
        }

        return result;
    }
};