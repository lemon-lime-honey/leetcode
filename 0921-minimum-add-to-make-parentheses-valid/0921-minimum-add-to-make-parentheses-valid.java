class Solution {
    public int minAddToMakeValid(String s) {
        int[] result = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                result[0]++;
            } else if (result[0] > 0) {
                result[0]--;
            } else {
                result[1]++;
            }
        }

        return result[0] + result[1];
    }
}