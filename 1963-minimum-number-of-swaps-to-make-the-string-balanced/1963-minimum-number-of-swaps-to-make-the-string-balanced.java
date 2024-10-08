class Solution {
    public int minSwaps(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                result++;
            } else if (result > 0) {
                result--;
            }
        }

        return (result + 1) / 2;
    }
}