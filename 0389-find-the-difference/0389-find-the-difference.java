class Solution {
    public char findTheDifference(String s, String t) {
        String str = s + t;
        char result = 0;

        for (int i = 0; i < str.length(); i++) {
            result = (char)(result^str.charAt(i));
        }

        return result;
    }
}