class Solution {
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        int now = pref[0];
        result[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            result[i] = now ^ pref[i];
            now = pref[i];
        }

        return result;
    }
}