class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int idx = 0;

        while (idx < v1.length && idx < v2.length) {
            int n1 = Integer.parseInt(v1[idx]);
            int n2 = Integer.parseInt(v2[idx]);

            if (n1 < n2) return -1;
            else if (n1 > n2) return 1;
            idx++;
        }

        while (idx < v1.length) {
            if (Integer.parseInt(v1[idx]) != 0) return 1;
            idx++;
        }

        while (idx < v2.length) {
            if (Integer.parseInt(v2[idx]) != 0) return -1;
            idx++;
        }

        return 0;
    }
}