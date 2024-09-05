class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            int idx = (columnNumber - 1) % 26;
            result = result.append((char)('A' + idx));
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.reverse().toString();
    }
}