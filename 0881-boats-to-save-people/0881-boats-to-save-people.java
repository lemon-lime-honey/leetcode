class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lo = 0, hi = people.length - 1;
        int result = 0;

        while (lo <= hi) {
            if (people[lo] + people[hi] <= limit) {
                lo++;
                hi--;
            } else {
                hi--;
            }
            result++;
        }

        return result;
    }
}