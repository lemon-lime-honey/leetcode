class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        int n = s.length();

        while (lo < hi) {
            while (lo < n && !Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            }
            while (hi > -1 && !Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            }
            if (lo > hi) break;
            if (Character.toLowerCase(s.charAt(lo)) !=
                Character.toLowerCase(s.charAt(hi))) {
                    return false;
                }
            
            lo++;
            hi--;
        }

        return true;
    }
}