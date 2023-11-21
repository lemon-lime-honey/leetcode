class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int compare = 0;
        int number = x;
        while (number > 0) {
            compare = compare * 10 + number % 10;
            number = number / 10;
        }
        if (compare == x) {
            return true;
        }
        return false;
    }
}