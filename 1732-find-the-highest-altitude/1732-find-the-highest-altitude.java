class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0, num = 0;

        for (int n: gain) {
            num += n;
            result = Math.max(result, num);
        }

        return result;
    }
}