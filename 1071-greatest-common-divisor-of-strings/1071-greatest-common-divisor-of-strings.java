class Solution {
    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int idx = gcd(Math.max(str1.length(), str2.length()), Math.min(str1.length(), str2.length()));
        return str1.substring(0, idx);
    }
}