class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;

        long long comp = 0, num = x;

        while (num > 0) {
            comp = comp * 10 + num % 10;
            num /= 10;
        }

        return comp == x;
    }
};