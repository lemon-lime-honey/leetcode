class Solution {
    public String intToRoman(int num) {
        int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            while (arabic[i] <= num) {
                num -= arabic[i];
                sb.append(roman[i]);
            }
        }

        return sb.toString();
    }
}