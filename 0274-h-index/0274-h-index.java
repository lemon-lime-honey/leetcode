import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1;
        int count = 0;

        while (i > -1 && count < citations[i]) {
            i--;
            count++;
        }

        return count;
    }
}