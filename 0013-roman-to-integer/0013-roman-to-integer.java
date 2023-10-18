import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int n = s.length();
        int result = 0;
        int i = 0;

        while (i < n) {
            if (i == n - 1) {
                result += roman.get(s.charAt(i));
                i++;
            } else {
                if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                    result += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                    i += 2;
                } else {
                    result += roman.get(s.charAt(i));
                    i++;
                }
            }
        }

        return result;
    }
}