class Solution {
    public String reverseVowels(String s) {
        String vowels = "AaEeIiOoUu";
        char[] result = s.toCharArray();
        int lo = 0, hi = s.length() - 1;

        while (lo < hi) {
            while (lo < hi && vowels.indexOf(result[lo]) == -1) {
                lo++;
            }

            while (hi > -1 && vowels.indexOf(result[hi]) == -1) {
                hi--;
            }

            if (lo < hi) {
                char temp = result[lo];
                result[lo] = result[hi];
                result[hi] = temp;
                lo++;
                hi--;
            }
        }

        return new String(result);
    }
}