class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int s = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) s += customers[i];
            customers[i] *= grumpy[i];
        }

        int lo = 0, hi = minutes - 1, total = 0;

        for (int i = 0; i < minutes; i++) {
            total += customers[i];
        }

        int now = total;

        while (hi < customers.length - 1) {
            now -= customers[lo++];
            now += customers[++hi];
            if (total < now) total = now;
        }

        return s + total;
    }
}