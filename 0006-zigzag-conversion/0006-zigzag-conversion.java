class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }

        int idx = 0;
        int ref = 1;

        for (int i = 0; i < s.length(); i++) {
            sb[idx].append(s.charAt(i));
            if (idx == 0) {
                ref = 1;
            } else if (idx == numRows - 1) {
                ref = -1;
            }
            idx += ref;
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}