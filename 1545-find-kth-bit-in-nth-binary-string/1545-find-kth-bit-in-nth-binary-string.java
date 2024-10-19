class Solution {
    private StringBuilder result;

    private void find(int n) {
        if (n == 1) {
            result.append("0");
            return;
        }

        find(n - 1);

        StringBuilder sb = new StringBuilder();
        sb.append("1");

        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        result.append(sb);
    }

    public char findKthBit(int n, int k) {
        result = new StringBuilder();
        find(n);

        return result.charAt(k - 1);
    }
}