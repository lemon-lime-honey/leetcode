class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[52];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                letters[s.charAt(i) - 'A']++;
            } else {
                letters[s.charAt(i) - 'a' + 26]++;
            }
        }
        boolean odd = false;
        int result = 0;
        for (int num: letters) {
            if (num % 2 == 1) {
                if (!odd) {
                    odd = true;
                    result += num;
                } else {
                    result += num - 1;
                }
            } else {
                result += num;
            }
        }
        return result;
    }
}